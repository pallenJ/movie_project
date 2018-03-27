package mp.board.model;

import java.util.List;

import mp.board.bean.Notice;

//공지사항 DAO

public interface NoticeDao {
	//공지 등록
	void register(Notice notice);
	  
	//전체 공지 목록
	List<Notice> noticelist();
	List<Notice> noticeSearch(String search , String keyword);
	
	//공지 정보 상세보기
	Notice noticedetail(int no);
	
	//공지 수정
	void noticeEdit(Notice notice);
	
	//공지 삭제
	boolean noticedelete(int no, String adminpw);

	Notice readPlus(Notice notice);
	
}	
