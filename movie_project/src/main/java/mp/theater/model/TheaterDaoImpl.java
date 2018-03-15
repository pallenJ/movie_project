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
		if(rs.next()) {
			return new Theater(rs);
		} else {
			log.debug("데이터 없음 : null값 반환");
			return null;
		}
	};
	
	
	//영화관 등록
	public void register(Theater theater) {
		String sql = "insert into theater values (?, ?, ?, ?, ?, ?)";
		Object[] args = {"'t'||LPAD(theater_seq.nextval, '10', '0')", theater.getName(),
				theater.getRegion(), theater.getAddress(), theater.getTel(), 
				theater.getManager()};
		jdbcTemplate.update(sql, args);
	}

	//내 영화관 조회 (지점 입장)
	@Override
	public Theater mytheater(String managerid) {
		String sql = "select * from theater where manager = ?";
		return jdbcTemplate.query(sql, extractor, managerid);
	}

	//내 영화관 수정 (지점 입장)
	@Override
	public void theateredit(Theater theater) {
		String sql = "update theater set name = ?, region = ?, address = ?, "
				+ "tel = ?, manager = ? where id = ?";
		Object[] args = {theater.getName(), theater.getRegion(), theater.getAddress(),
				theater.getTel(), theater.getManager(), theater.getId()};
		jdbcTemplate.update(sql, args);
	}

	@Override
	public void theaterdelete(String theaterid, String managerpw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Theater> alltheater() {
		// TODO Auto-generated method stub
		return null;
	}

}
