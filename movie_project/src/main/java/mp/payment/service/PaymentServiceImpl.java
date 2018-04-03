package mp.payment.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mp.member.bean.Member;
import mp.member.model.MemberDao;
import mp.movie.bean.Movie;
import mp.movie.model.MovieDao;
import mp.payment.bean.Payment;
import mp.payment.model.PaymentDao;
import mp.theater.model.SeatDao;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	MemberDao memberDao;

	@Autowired
	MovieDao movieDao;
	
	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	SeatDao seatDao;
	
	@Autowired
	ServletContext application;
	
	

	@Override
	public Member getMemberInfo(String memberid) {
		Member member = memberDao.myinfo(memberid);
		return member;
	}

	
	@Override
	public Movie getMovieInfo(String movieid) {
		Movie movie = movieDao.movieinfo(movieid);
		return movie;
	}
	

	@Override
	public Payment setPaymentInfo(Payment payment, int movieprice, int adult, int child, int senior) {		
		//연령대 가격 계산
		int adultdiscount=0;
		int childdiscount = 3000; //어린이 할인 가격
		int seniordiscount = 3000; //어린이 할인 가격
		int holiday = 2000; //주말 가격
		int paytotal = movieprice*(adult+child+senior);
		int morningstart = 6;	//조조시작시간
		int morningend = 15;	//조조종료시간
		int nightstart = 23;		//야간시작시간
		int nightend = 6;		//야간종료시간
		int morningdiscount = 3000;
		int nightdiscount = 3000;
		
		paytotal = paytotal-(adultdiscount*adult+childdiscount*child+senior*seniordiscount);	//연령층별 차등
		log.debug("연령별 차등가격 적용  어린이 : {}명, 어른:{}명, 어르신:{}명, 적용가격:{}",child,adult,senior,paytotal);
		Date date = new Date();
		//요일별 가격 계산
		SimpleDateFormat sdf2 = new SimpleDateFormat("E");
		String week = sdf2.format(date);
		if(week.equals("토")||week.equals("일")) {
			paytotal+=holiday;
		}
		log.debug("요일 가격 적용  {}요일 변동가격: {}",week,paytotal);
		
		//조조할인, 야간할인
		SimpleDateFormat sdf3 = new SimpleDateFormat("HH");
		String temp = sdf3.format(date);
		int hour = Integer.parseInt(temp);
		if(hour>=morningstart && morningend>=hour){
			paytotal-=morningdiscount;
			log.debug("조조 할인 적용  : {}",paytotal);
		}else if(hour>=nightstart||hour<=nightend){
			paytotal-=nightdiscount;
			log.debug("야간 할인 적용  : {}",paytotal);
		}
		
		//날짜 계산
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String paydate = sdf.format(date);
		
		
		log.debug("Paymentserviceimpl paytotal :{}",paytotal);
		log.debug("Paymentserviceimpl paydate :{}",paydate);
//		payment.setPaytotal(paytotal);											//테스트용으로 주석
		payment.setPaytotal(50);												//결제테스트용
		payment.setPaydate(paydate);
		return payment;
	}

	@Override
	public boolean register(Payment payment) {
		
		//좌석이 s00000001,s00000002 String형태로 넘어온 상태기에 split를 이용해서 배열로 추가
		log.debug("serviceimpl scheduleid : {}",payment.getScheduleid());
		String seatidbundle = payment.getSeatid();
		log.debug("seatidbundle : {}",seatidbundle);
		String[] seatidArray = seatidbundle.split(",");
		log.debug("seatidArray[0] : {}, length : {}",seatidArray[0],seatidArray.length);
		boolean check = true;
		
		//중복값 없을 시
		//결제 정보 등록 seatid별로 반복처리
		for(String seatid: seatidArray) {
			payment.setSeatid(seatid);
		    paymentDao.register(payment);
		}		

		log.debug("paymentServiceimpl register메소드 등록 여부 : {}",check);
		return check;
	}


	@Override
	public boolean check(Payment payment, String loginid) {
		//좌석이 s00000001,s00000002 String형태로 넘어온 상태기에 split를 이용해서 배열로 추가
		String seatidbundle = payment.getSeatid();
		String[] seatidArray = seatidbundle.split(",");
		boolean check = true;
		
		List<String> list=null;
		
		//데이터베이스에 등록된 예매 좌석인지 확인
		for(String seatid: seatidArray) {
			payment.setSeatid(seatid);
			log.debug("seatid :{}",seatid);
			check =  paymentDao.checkRegister(payment.getScheduleid(),seatid);		//중복되면 false
			log.debug("데이터베이스 중복여부 check : {}",check);
			if(!check) {
				return false;	//중복 등록시 false반환
			}
			//어플리케이션 영역에서 좌석 정보 가져오기
			Enumeration attrEnum = application.getAttributeNames();
			while(attrEnum.hasMoreElements()){
			  String name = (String)attrEnum.nextElement();
			  //정규표현식으로 어플리케이션영역에서 id만 추출
		      String pattern = "^[a-zA-Z0-9]*$";	//영문 숫자만 가능
		      boolean i = Pattern.matches(pattern, name);
		      //어플리케이션 영역에서 아이디 형식이라면 중복 확인한다.
		      if(i==true)
		      {
		            log.debug("{}는 패턴에 일치함",name);
		            Object value = application.getAttribute(name);
					log.debug("어플리케이션 저장 좌석 : {}",value);
					  if(value!=null) {
						   //어플리케이션 영역의 모든 좌석값 가져오기
						   list =  (List<String>)value;
					        
							//리스트에서 스트링분해해서 비교한다.
							for(String s: list) { 
								String schedule = s.substring(0, 11);
								String seat = s.substring(11);
								log.debug("매개 scheduleid : {}, 매개 seatid : {}, 어플리케이션 scheduleid : {}, seatid : {}",payment.getScheduleid(),seatid,schedule,seat);
								if(payment.getScheduleid().equals(schedule)&&seatid.equals(seat)) {
									log.debug("어플리케이션영역에서 중복");
									return false;	//중복 등록시 false반환
								}
							}
					  }
		            
		      }//if
		   }//while

			
			
//			//어플리케이션 영역에 아무것도 없으면 리스트 생성해서 넣는다. 이름은 세션값  
//			if(application.getAttribute(loginid)==null) {
//				list = new ArrayList<>();
//				log.debug("어플리케이션 {}  : 널이다.",loginid);
//				application.setAttribute(loginid,list);
//				log.debug("어플리케이션  : {}",application.getAttribute(loginid));
//			}else {	
//				
//			//어플리케이션에 값이 있다면
//				log.debug("어플리케이션 {} : 널아니다.",loginid);
//				list = (List<String>) application.getAttribute(loginid);
//				//리스트에서 스트링분해해서 비교한다.
//				for(String s: list) { 
//					String schedule = s.substring(0, 11);
//					String seat = s.substring(11);
//					log.debug("매개 scheduleid : {}, 매개 seatid : {}, 어플리케이션 scheduleid : {}, seatid : {}",payment.getScheduleid(),seatid,schedule,seat);
//					if(payment.getScheduleid().equals(schedule)&&seatid.equals(seat)) {
//						log.debug("어플리케이션영역에서 중복");
//						return false;	//중복 등록시 false반환
//					}
//				}
//			}	
		}
	    //중복되는 거 없다면
        list = new ArrayList<>();
		//이 사용자가 선택한 스케줄, 좌석정보를 어플리케이션영역에 넣는다.
		for(String seat : seatidArray) {
			String temp = payment.getScheduleid()+seat;
			log.debug("어플리케이션영역에 {} 추가",temp);
			list.add(temp);
		}
		application.setAttribute(loginid, list);
		log.debug("application 등록 후 : {}",application.getAttribute(loginid));
		
		

		return true;
	}


	@Override
	public List<String> getSeatlist(String scheduleid) {
		List<String> list = paymentDao.getSeatlist(scheduleid);
		//어플리케이션 영역의 이 스케줄에 해당하는 모든 좌석 가져오기
		

		log.debug("어플리케이션에서 좌석정보 가져오기");
		//어플리케이션 영역에서 좌석 정보 가져오기
		Enumeration attrEnum = application.getAttributeNames();
		while(attrEnum.hasMoreElements()){
		  String name = (String)attrEnum.nextElement();
		  //정규표현식으로 어플리케이션영역에서 id만 추출
		  log.debug("name : {}",name);
	      String pattern = "^[a-zA-Z0-9]*$";	//영문 숫자만 가능
	      boolean i = Pattern.matches(pattern, name);
	      //어플리케이션 영역에서 아이디 형식이라면 중복 확인한다.
	      if(i==true)
	      {
	            log.debug("{}는 패턴에 일치함",name);
	            Object value = application.getAttribute(name);
				log.debug("어플리케이션 저장 좌석 : {}",value);
				  if(value!=null) {
					   //어플리케이션 영역의 모든 좌석값 가져오기
					   list =  (List<String>)value;
				        
						//리스트에서 스트링분해해서 비교한다.
						for(String s: list) { 
							String schedule = s.substring(0, 11);
							String seat = s.substring(11);
							log.debug("어플리케이션영역 확인 schedule : {}",schedule );
							log.debug("어플리케이션영역 확인 scheduleid : {}",scheduleid);
							if(schedule.equals(scheduleid)) {		//상영시간표가 같으면 seat추가하기
								log.debug("어플리케이션영역에서 seat : {} 추가",seat);
								list.add(seat);
							}
						}
				  }
	            
	      }//if
	   }//while
		

		return list;
	}

}
