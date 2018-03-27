package mp.board.service;

import java.util.List;

import mp.board.bean.Notice;

public interface NoticeService {
	List<Notice> noticePaging(int cnum);
	List<Notice> noticePaging(int page,int cnum);
	int[] noticePaging(int cnum,int pnum,int page);
	void noticeWrite(String id, String head, String title,  String content);
}
