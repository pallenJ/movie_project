package mp.theater.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mp.theater.bean.Seat;

@Service
public interface SeatService {
	//좌석 등록
	void register(String seat, String screen);
	//좌석 리스트 (상세 보기)
	List<Seat> list(String screenid);
}
