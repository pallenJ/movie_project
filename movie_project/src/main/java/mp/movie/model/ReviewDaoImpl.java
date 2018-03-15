package mp.movie.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.movie.bean.Review;

@Repository("ReviewDao") 
public class ReviewDaoImpl implements ReviewDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Review> mapper = (rs, index)->{
		return new Review(rs);
	};
	
	//리뷰 등록
	@Override
	public void register(Review review) {
		String sql = "insert into review values (?, ?, ?, ?, ?, sysdate);";
		Object[] args = {};
		jdbcTemplate.update(sql, args);
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
