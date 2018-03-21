package mp.theater.service;

import org.springframework.stereotype.Service;

import mp.theater.bean.Screen;

@Service
public interface ScreenService {
	//상영관 등록
	String register(String no, String theater, String seats, String uploader);
	
	//상영관 상세 조회
	Screen detail(String screenid);

}
