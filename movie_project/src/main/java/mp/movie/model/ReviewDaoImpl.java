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
		Object[] args = {review.getId(), review.getStar(), review.getContent(), review.getMovieid()};
		jdbcTemplate.update(sql, args);
	}

	//리뷰 목록 조회
	@Override
	public List<Review> reviewlist(String movieid) {
		String sql = "select * from review order by reg desc;";
		return jdbcTemplate.query(sql, mapper);
	}

	//리뷰 수정
	@Override
	public void reviewedit(Review review) {
		String sql = "update review set star = ?, content = ?";
		jdbcTemplate.update(sql, review.getStar(), review.getContent());
	};

	//리뷰 삭제
	@Override
	public void reviewdelete(String reviewid, String sessionid, String userpw) {
		String sql = "delete from review where ";
	}

}
