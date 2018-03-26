package mp.board.model;

import java.util.List;

import mp.board.bean.Qna;

//문의게시판 DAO(고객, 고객센터)

public interface QnaDao {
//------ 고객, 고객센터 ------ 
	
	//문의글 등록
	void register(Qna qna);
	void register(Qna qna,int parent);
	
	//문의글 전체 목록
	List<Qna> qnalist();
	
	//상세보기
	Qna qnadetail(int no);
	
	//수정
	void qnaedit(Qna qna);
	
	//삭제
	boolean qnadelete(int no, String userpw);
	boolean qnadelete(int no);

	List<Qna> qnaSearch(String search,String keyword);
	
	Qna readPlus(Qna qna);

	
	
	//
}
