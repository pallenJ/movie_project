package mp.theater.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import mp.theater.bean.Seat;

//좌석 DAO(상영관 내)
@Repository 
public interface SeatDao {
	//좌석 추가
	void register(List<Seat> list);
	
	//상영관 내 좌석 목록
	List<Seat> seatlist(String screenid);

	//좌석 수정
	void seatedit(Seat seat);
	
	//좌석 삭제
	void seatdelete(String seatid);
	
	//좌석 조회
	Seat info(String seatid);
}
