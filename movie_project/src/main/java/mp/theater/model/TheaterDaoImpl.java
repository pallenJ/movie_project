package mp.theater.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.theater.bean.Theater;

@Repository("theaterDao")
public class TheaterDaoImpl implements TheaterDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Logger log = LoggerFactory.getLogger(getClass());

	private RowMapper<Theater> mapper = (rs, index) -> {
		return new Theater(rs);
	};
	
	private ResultSetExtractor<Theater> extractor = rs -> {
		if (rs.next()) {
			return new Theater(rs);
		} else {
			log.debug("데이터 없음 : null값 반환");
			return null;
		}
	};

	// 영화관 등록 (지점 입장)
	public String register(Theater theater) {
		String sql = "select 't'||LPAD(theater_seq.nextval, '10', '0') from dual";
		String id = jdbcTemplate.queryForObject(sql, String.class);
		sql = "insert into theater values (?, ?, ?, ?, ?, (select no from member where id = ?))";
		Object[] args = { id, theater.getName(), theater.getRegion(), theater.getAddress(), theater.getTel(),
				theater.getManager() };
		jdbcTemplate.update(sql, args);
		log.debug("영화관 등록이 완료되었습니다");
		return id;
	}

	// 영화관 상세 조회 (지점 입장)
	@Override
	public Theater mytheater(String managerid) {
		String sql = "select * from theater where manager = (select no from member where id = ?)";
		return jdbcTemplate.query(sql, extractor, managerid);
	}

	// 내 영화관 수정 (지점 입장)
	@Override
	public void theateredit(Theater theater) {
		String sql = "update theater set name = ?, region = ?, address = ?, " + "tel = ?, manager = ? where id = ?";
		Object[] args = {theater.getName(), theater.getRegion(), theater.getAddress(), theater.getTel(),
				theater.getManager(), theater.getId() };
		jdbcTemplate.update(sql, args);
		log.debug("영화관 수정이 완료되었습니다");
	}

	// 영화관 삭제 (지점 입장)
	@Override
	public void theaterdelete(String theaterid, String sessionid, String managerpw) {
		String sql = "delete from theater where id = ? and manager = "
				+ "(select no from member where id = ? and pw = ?)";
		Object[] args = { theaterid, sessionid, managerpw };
		int result = jdbcTemplate.update(sql, args);
		if (result == 1) {
			log.debug("영화관이 삭제되었습니다.");
		} else {
			log.debug("영화관이 삭제되지 않았습니다.");
		}
	}

	// 영화관 목록 조회 (고객 입장)
	@Override
	public List<Theater> alltheater() {
		String sql = "select * from theater";
		return jdbcTemplate.query(sql, mapper);
	}

	// 영화관 상세 조회 (고객 입장)
	@Override
	public Theater theaterdetail(String theaterid) {
		String sql = "select * from theater where id = ?";
		return jdbcTemplate.query(sql, extractor, theaterid);
	}
	

}
