package mp.theater.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import mp.theater.bean.Screen;
  
//상영관관리 DAO(영화관 내 각 상영관)
@Repository 
public interface ScreenDao {
	
	//상영관 등록
	String register(Screen screen);
	
	//상영관 정보 
	Screen screendetail(String screenid);
	
	//상영관 목록(세션 아이디로 검색)
	List<Screen> screenmylist(String sessionid);
	
	//상영관 목록(영화관 아이디로 검색)
	List<Screen> screenlist(String theaterid);
	
	//상영관 정보 수정
	void screenedit(Screen screen);
	
	//상영관 삭제
	void screendelete(String screenid, String sessionid, String managerpw);
	
}
