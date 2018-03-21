package mp.theater.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mp.theater.bean.Screen;

@Service
public interface ScreenService {
	//상영관 등록
	String register(String no, String theater, String seats, String id);
	
	//상영관 상세 조회
	Screen detail(String screenid);

	//상영관 목록 조회
	List<Screen> list(String sessionid);
	
	//상영관 수정
	void edit(String no, String theaterid, String seats, String uploader);

	//상영관 삭제
	void delete(String screenid, String sessionid, String managerpw);

}
