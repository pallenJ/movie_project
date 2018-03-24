package mp.board.service;

import java.util.List;

import mp.board.bean.Notice;
import mp.board.bean.Qna;

public interface QnaService {
	List<Qna> qnaPaging(int cnum);
	List<Qna> qnaPaging(int page,int cnum);
	int[] qnaPaging(int cnum,int pnum,int page);
}
