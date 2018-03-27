package mp.board.service;

import java.util.List;

import mp.board.bean.Notice;
import mp.board.bean.Qna;

public interface NoticeService {
	List<Notice> noticePaging(int cnum);
	List<Notice> noticePaging(int page,int cnum);
	List<Notice> noticePaging(int page, int cnum, String search, String keyword);
	int[] noticePaging(int cnum,int pnum,int page);
	void noticeWrite(String id, String head, String title,  String content);
	void noticeEdit(String no, String head, String title, String content);
	int[] noticePaging(int cnum, int pnum, int page, String search, String keyword);
}
