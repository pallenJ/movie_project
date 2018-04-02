package mp.theater.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.theater.bean.Seat;

@Repository("seatDao") 
public class SeatDaoImpl implements SeatDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Logger log = LoggerFactory.getLogger(getClass());
	
	private RowMapper<Seat> mapper = (rs, index) -> {
		return new Seat(rs);
	};
	
	private ResultSetExtractor<Seat> extractor = rs -> {
		if(rs.next()) {
			return new Seat(rs);
		} else {
			log.debug("데이터 없음 : null값 반환");
			return null;
		}
	};
	
	//좌석 등록
	@Override
	public void register(List<Seat> list) {
		//seat 시퀀스 번호 추출
		String sql = "select 's'||LPAD(seat_seq.nextval, '10', '0') from dual connect by level <= ?";
		List<String> seq = jdbcTemplate.queryForList(sql, String.class, list.size());
		
		//batchUpdate -> 다중 sql 명령문 처리 위해서 사용 
		sql = "insert into seat values (?, ?, ?, ?, ?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				//ps가 명령 생성기		ps.set???
				//index				위치(list에서의 위치)
				ps.setString(1, seq.get(index));
				ps.setString(2, list.get(index).getScreenid());
				ps.setString(3, list.get(index).getReallocation());
				ps.setString(4, list.get(index).getServicelocation());
				ps.setInt(5, list.get(index).getSeatdiscount());
			}
			@Override
			public int getBatchSize() {
				// return 반복할횟수;
				return list.size();
			}
		});
		sql = "update screen set seats = (select count(*) from seat where screenid=?) where id = ?";
		jdbcTemplate.update(sql, list.get(0).getScreenid(), list.get(0).getScreenid());
		log.debug("좌석 등록이 완료되었습니다");
	}

	//상영관 당 좌석 목록 조회
	@Override
	public List<Seat> seatlist(String screenid) {
		log.debug(screenid);
		String sql = "select * from seat where screenid = ?";
		return jdbcTemplate.query(sql, mapper, screenid);
	}

	//좌석 수정
	@Override
	public void seatedit(Seat seat) {
		String sql = "update seat set screenid = ?, reallocation=?, "
				+ "servicelocation = ?, seatdiscount = ? where id = ?";
		Object[] args = {seat.getScreenid(), seat.getReallocation(), 
				seat.getServicelocation(), seat.getSeatdiscount(), seat.getId()};
		jdbcTemplate.update(sql, args);
		log.debug("좌석이 수정되었습니다");
	}

	//좌석 삭제
	@Override
	public void seatdelete(String seatid) {
		String sql = "delete from seat where id = ?";
		int result = jdbcTemplate.update(sql, seatid);
		if(result == 0) {
			log.debug("좌석이 삭제되었습니다!");
		} else {
			log.debug("좌석이 삭제되지 않았습니다");
		}
	}

	//좌석 조회 (좌석 아이디로 검색)
	@Override
	public Seat info(String seatid) {
		String sql = "select * from seat where id = ?";
		return jdbcTemplate.query(sql, extractor, seatid);
	}

}
