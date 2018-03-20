package mp.movie.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.movie.bean.Review;
 
@Repository("reviewDao") 
public class ReviewDaoImpl implements ReviewDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Logger log = LoggerFactory.getLogger(getClass());
	
	private RowMapper<Review> mapper = (rs, index)->{
		return new Review(rs);
	};
	
	
	//리뷰 등록
	@Override 
	public void register(Review review) {
		String sql = "select 'r'||LPAD(review_seq.nextval, '10', '0') from dual";
		String id = jdbcTemplate.queryForObject(sql, String.class);
		sql = "?, ?, ?, ?, ?, sysdate)";
		Object[] args = {id, review.getStar(), review.getWriter(), review.getContent(), review.getMovieid()};
		jdbcTemplate.update(sql, args);
	}

	//리뷰 목록 조회
	@Override
	public List<Review> reviewlist(String movieid) {
		String sql = "select * from review where movieid = ? order by reg desc";
		return jdbcTemplate.query(sql, mapper, movieid);
	}

	//리뷰 수정
	@Override
	public void reviewedit(Review review) {
		String sql = "update review set star = ?, content = ? where id = ?";
		jdbcTemplate.update(sql, review.getStar(), review.getContent(), review.getId());
	};

	//리뷰 삭제
	@Override
	public void reviewdelete(String reviewid, String sessionid, String userpw) {
		String sql = "delete from review where id=? and writer = "
				+ "(select no from member where id=? and pw=?)";
		int result = jdbcTemplate.update(sql, reviewid, sessionid, userpw);
		if(result==1) { //삭제 완료
			log.debug("리뷰가 삭제되었습니다");
		} else {
			log.debug("리뷰가 삭제되지 않았습니다");
		}
	}

}
