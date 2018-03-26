package mp.board.service;

import java.util.List;

import mp.board.bean.Notice;
import mp.board.bean.Qna;

public interface QnaService {
	List<Qna> qnaPaging(int cnum);
	List<Qna> qnaPaging(int page,int cnum);
	int[] qnaPaging(int cnum,int pnum,int page);
	
	void  qnaWrite(String id,String head,String title,String secret,String content);
	void  qnaWrite(String id,String head,String title,String secret,String content,String parent);
	
	List<Qna> qnaPaging(int page, int cnum, String search, String keyword);
	
	int[] qnaPaging(int cnum, int pnum, int page, String search, String keyword);
	void qnaEdit(String no,String head,String title,String content, String secret);
}
