package mp.theater.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mp.theater.bean.Screen;
import mp.theater.model.ScreenDao;

@Service("screenService")
public class ScreenServiceImpl implements ScreenService {
	@Autowired
	private ScreenDao screenDao;
	
	//상영관 등록
	@Override
	public String register(String no, String theater, String uploader) {
		Screen s = new Screen();
		s.setNo(Integer.parseInt(no)); s.setTheaterid(theater);
		s.setUploader(uploader);
		return screenDao.register(s);
	}

	//상영관 상세 조회
	@Override
	public Screen detail(String screenid) {
		return screenDao.screendetail(screenid);
	}

	//상영관 목록 조회 (세션 아이디로 조회)
	@Override
	public List<Screen> mylist(String sessionid) {
		return screenDao.screenmylist(sessionid);
	}
	
	//상영관 목록 조회 (영화관 아이디로 조회)
	@Override
	public List<Screen> list(String theaterid){
		return screenDao.screenlist(theaterid);
	}

	//상영관 수정
	@Override
	public void edit(String no, String theaterid, String seats, String id) {
		Screen s = new Screen();
		s.setNo(Integer.parseInt(no)); s.setTheaterid(theaterid);
		s.setSeats(Integer.parseInt(seats)); s.setId(id);
		screenDao.screenedit(s);
	}

	//상영관 삭제
	@Override
	public void delete(String screenid, String sessionid, String managerpw) {
		screenDao.screendelete(screenid, sessionid, managerpw);
	}
}