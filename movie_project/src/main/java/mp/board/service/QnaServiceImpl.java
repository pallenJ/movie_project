package mp.board.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mp.board.bean.Notice;
import mp.board.bean.Qna;
import mp.board.model.QnaDao;

@Service("qnaService")
public class QnaServiceImpl implements QnaService{
	
	@Autowired
	QnaDao qnadao;
	
	@Override
	public List<Qna> qnaPaging(int page,int cnum) {
		/*int pageFirst = 10*(page/10)+1;
		int pageLast = 10*(page/10+1);*/
		List<Qna> list = qnadao.qnalist(); 
//		Collections.reverse(list);
		
		int maximum = list.size();
		int start = 10*(page-1);
		int end   = Math.min(10*page-1, maximum);
		
		return list.subList(start, end);
	}

	@Override
	public List<Qna> qnaPaging(int cnum) {
		// TODO Auto-generated method stub
		return qnaPaging(1,cnum);
	}

	

}
