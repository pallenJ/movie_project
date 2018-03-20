package mp.payment.service;

import org.springframework.stereotype.Service;

import mp.member.bean.Member;
import mp.movie.bean.Movie;

@Service
public interface PaymentService {
	void register();

	//회원 정보가져오는 메소드
	Member getMemberInfo(String memberid);
	
	//영화 정보가져오는 메소드
	Movie getMovieInfo(String movieid);
}	
