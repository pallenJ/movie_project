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
	public void register() {
		System.out.println("등록서비스 작동");
	}

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
	public void register(Payment payment) {
		paymentDao.register(payment);
		log.debug("paymentServiceimpl register 등록 완료 ");
	}
	
	

}
