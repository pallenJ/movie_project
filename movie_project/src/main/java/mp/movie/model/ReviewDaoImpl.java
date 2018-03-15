package mp.movie.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import mp.movie.bean.Review;

@Repository("ReviewDao") 
public class ReviewDaoImpl implements ReviewDao {

	@Override
	public void register(Review review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Review> reviewlist(String movieid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reviewedit(Review review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reviewdelete(String reviewid, String userpw) {
		// TODO Auto-generated method stub
		
	}

}
