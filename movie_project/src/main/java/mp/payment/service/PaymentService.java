package mp.payment.service;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;

import mp.member.bean.Member;
import mp.movie.bean.Movie;
import mp.payment.bean.Payment;

@Service
public interface PaymentService {

	//회원 정보가져오는 메소드
	Member getMemberInfo(String memberid);
	
	//영화 정보가져오는 메소드
	Movie getMovieInfo(String movieid);
	

	//결제 가격정보, 예매날짜정보 입력 메소드  (멤버정보는 별도 처리)
	Payment setPaymentInfo(Payment payment, int movieprice, int adult, int child, int senior);

	//결제(예매)정보 데이터베이스에 등록
	boolean register(Payment payment);

	//결제 등록 전 중복여부 확인
	boolean check(Payment payment, String loginid);

	List<String> getSeatlist(String scheduleid);
}	
