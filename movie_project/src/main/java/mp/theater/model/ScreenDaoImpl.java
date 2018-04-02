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
	public String register(Screen screen) {
		String sql = "select 'c'||LPAD(screen_seq.nextval, '10', '0') from dual";
		String id = jdbcTemplate.queryForObject(sql, String.class);
		sql = "insert into screen values (?, ?, (select id from theater where name = ?),"
				+ " 0, (select no from member where id = ?))";
		Object[] args = {id, screen.getNo(), screen.getTheaterid(), screen.getUploader()};
		jdbcTemplate.update(sql, args);
		log.debug("상영관 등록이 완료되었습니다");
		return id;
	}

	//상영관 상세 조회
	@Override
	public Screen screendetail(String screenid) {
		String sql = "select * from screen where id = ?";
		return jdbcTemplate.query(sql, extractor, screenid);
	}

	//상영관 목록 조회 (세션 아이디로 검색)
	@Override
	public List<Screen> screenmylist(String sessionid) {
		String sql = "select * from screen where uploader = "
				+ "(select no from member where id = ?) order by no asc";
		return jdbcTemplate.query(sql, mapper, sessionid);
	}
	
	//상영관 목록 조회 (상영관 아이디로 검색)
	@Override
	public List<Screen> screenlist(String theaterid) {
		String sql = "select * from screen where theaterid = ?";
		return jdbcTemplate.query(sql, mapper, theaterid);
	}

	//상영관 수정
	@Override
	public void screenedit(Screen screen) {
		String sql = "update screen set no = ?, theaterid = ?, seats = ? "
				+ "where id = ?";
		Object[] args = {screen.getNo(), screen.getTheaterid(), screen.getSeats(), screen.getId()};
		jdbcTemplate.update(sql, args);
		log.debug("상영관 수정이 완료되었습니다");
	}

	//상영관 삭제
	@Override
	public void screendelete(String screenid, String sessionid, String managerpw) {
		String sql = "delete from screen where id = ? and uploader = "
				+ "(select no from member where id = ? and pw = ?)";
		int result = jdbcTemplate.update(sql, screenid, sessionid, managerpw);
		if(result == 1) {
			log.debug("상영관 삭제가 완료되었습니다");
		} else {
			log.debug("상영관이 삭제되지 않았습니다");
		}
	}

}
