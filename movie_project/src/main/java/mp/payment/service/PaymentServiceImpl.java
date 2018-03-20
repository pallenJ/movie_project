package mp.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mp.member.bean.Member;
import mp.member.model.MemberDao;
import mp.movie.bean.Movie;
import mp.movie.model.MovieDao;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	MemberDao memberDao;

	@Autowired
	MovieDao movieDao;
	
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
	
	

}
