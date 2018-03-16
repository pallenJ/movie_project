package mp.theater.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.theater.bean.Screen;
  
@Repository("screenDao") 
public class ScreenDaoImpl implements ScreenDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Logger log = LoggerFactory.getLogger(getClass());
	
	private RowMapper<Screen> mapper = (rs, index) -> {
		return new Screen(rs);
	};
	private ResultSetExtractor<Screen> extractor = rs -> {
		if(rs.next()) {
			return new Screen(rs); 
		} else {
			log.debug("데이터 없음 : null값 반환!");
			return null;
		}
	};
	
	//상영관 등록
	@Override
	public void register(Screen screen) {
		String sql = "insert into screen value ('s'||LPAD(screen_seq.nextval, '10', '0'), ?, ?, ?, ?)";
		Object[] args = {screen.getNo(), screen.getTheaterid(), screen.getSeats(), screen.getUploader()};
		jdbcTemplate.update(sql, args);
	}

	//상영관 상세 조회
	@Override
	public Screen screendetail(String screenid) {
		String sql = "select * from screen where id = ?";
		return jdbcTemplate.query(sql, extractor, screenid);
	}

	//상영관 목록 조회
	@Override
	public List<Screen> screenlist(String theaterid) {
		String sql = "select * from screen order by no asc";
		return jdbcTemplate.query(sql, mapper);
	}

	//상영관 수정
	@Override
	public void screenedit(Screen screen) {
		String sql = "update from screen set no = ?, theaterid = ?, seats = ? "
				+ "where id = ?";
		Object[] args = {screen.getNo(), screen.getTheaterid(), screen.getSeats(), screen.getId()};
		jdbcTemplate.update(sql, args);
	}

	//상영관 삭제
	@Override
	public void screendelete(String screenid, String managerpw) {
		String sql = "delete from screen where uploader = "
				+ "(select no from memeber where id = ? and pw = ?)";
		jdbcTemplate.update(sql, screenid, managerpw);
	}

}
