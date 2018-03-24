package mp.board.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mp.board.bean.Qna;
import mp.board.model.QnaDao;
import mp.member.model.MemberDao;

@Service("qnaService")
public class QnaServiceImpl implements QnaService{
	
	@Autowired
	MemberDao memDao;
	
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
		int end   = Math.min(10*page, maximum);
		
		return list.subList(start, end);
	}

	@Override
	public List<Qna> qnaPaging(int cnum) {
		// TODO Auto-generated method stub
		return qnaPaging(1,cnum);
	}

	@Override
	public int[] qnaPaging(int cnum, int pnum, int page) {
		// TODO Auto-generated method stub
		
		int allCount = qnadao.qnalist().size();
		int last = allCount/cnum+(allCount%cnum==0?0:1);
		if(page>last) page = last;
		int pagingNum=pnum*((page-1)/pnum);
		int pageLast = last-pagingNum>=pnum?pnum:last%pnum;
		return new int[]{pagingNum,pageLast,last,page};
	}

	@Override
	public void qnaWrite(String id,String head, String title, String secret, 
			String content, String parent, String gno) {
		// TODO Auto-generated method stub
		String no = memDao.myinfo(id).getNo();
		
		Qna qna = new Qna();
		
		qna.setHead(head);
		qna.setTitle(title);
		qna.setSecret(secret);
		qna.setContent(content);
		qna.setWriterNo(no);
		qna.setWriterId(id);
		qna.setParent(Integer.parseInt(parent));
		qna.setGno(Integer.parseInt(gno));
		
		qnadao.register(qna);
	}

	
	
	

}
