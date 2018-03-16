package mp.theater.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	
	//좌석 등록
	@Override
	public void register(Seat seat) {
		String sql = "insert into seat values ('s'||LPAD(seat_seq.nextval, '10', "
				+ "'0'), ?, ?, ?, ?)";
		Object[] args = {seat.getScreenid(), seat.getReallocation(), 
				seat.getServicelocation(), seat.getSeatdiscount()};
		jdbcTemplate.update(sql, args);		
	}

	//상영관 당 좌석 목록 조회
	@Override
	public List<Seat> seatlist(String screenid) {
		String sql = "select * from seat where screenid = ?";
		return jdbcTemplate.query(sql, mapper, screenid);
	}

	//좌석 수정
	@Override
	public void seatedit(Seat seat) {
		String sql = "update seat set screenid = ?, reallocation=?, "
				+ "servicelocation=?, seatdiscount = ? where id = ?";
		Object[] args = {seat.getScreenid(), seat.getReallocation(), 
				seat.getServicelocation(), seat.getSeatdiscount(), seat.getId()};
		jdbcTemplate.update(sql, args);
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

}
