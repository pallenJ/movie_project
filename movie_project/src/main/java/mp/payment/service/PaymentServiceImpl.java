package mp.payment.service;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import mp.theater.bean.Seat;
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
		
		//기존 예매 좌석인지 확인
		for(String seatid: seatidArray) {
			payment.setSeatid(seatid);
			check =  paymentDao.checkRegister(payment.getScheduleid(),seatid);
			if(!check) {
				return false;	//중복 등록시 false반환
			}
		}
		
		//중복값 없을 시
		//결제 정보 등록 seatid별로 반복처리
		for(String seatid: seatidArray) {
			payment.setSeatid(seatid);
		    paymentDao.register(payment);
		}		

		log.debug("paymentServiceimpl register메소드 등록 여부 : {}",check);
		return check;
	}

	
	

}
