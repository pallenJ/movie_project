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

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	MemberDao memberDao;

	@Autowired
	MovieDao movieDao;
	
	@Autowired
	PaymentDao paymentDao;
	

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
	public Payment setPaymentInfo(Payment payment, int adult, int child, int senior) {
		
		int paytotal = 90*adult+50*child+30*senior;
				//임시가격으로 처리, 나중엔 영화에서 가져와야한다. 요일, 좌석 가격도 고려
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String paydate = sdf.format(date);

		log.debug("Paymentserviceimpl paytotal :{}",paytotal);
		log.debug("Paymentserviceimpl paydate :{}",paydate);
		payment.setPaytotal(paytotal);
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
