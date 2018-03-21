package mp.theater.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import mp.theater.bean.Theater;

// 영화관(지점) DAO 
@Repository
public interface TheaterDao {
//------ 지점장 ------
	//영화관 등록(지점 등록)
	String register(Theater theater);
	
	//내 영화관 정보 조회(지점장 본인의 영화관 조회)
	Theater mytheater(String managerid);
	
	//영화관 정보 수정
	void theateredit(Theater theater);
	
	//영화관 등록 삭제
	void theaterdelete(String theaterid, String sessionid, String managerpw);
	
//------ 고객 ------		
	//전체 영화관 조회
	List<Theater> alltheater();
	
	//영화관 상세 조회
	Theater theaterdetail(String theaterid);
}
