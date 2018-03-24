package mp.board.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mp.board.bean.Notice;
import mp.board.model.NoticeDao;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	NoticeDao noticeDao;
	
	@Override
	public List<Notice> noticePaging(int page,int cnum) {
		/*int pageFirst = 10*(page/10)+1;
		int pageLast = 10*(page/10+1);*/
		List<Notice> list = noticeDao.noticelist(); 
//		Collections.reverse(list);
		
		int maximum = list.size();
		int start = 10*(page-1);
		int end   = Math.min(10*page, maximum);
		
		return list.subList(start, end);
	}

	@Override
	public List<Notice> noticePaging(int cnum) {
		// TODO Auto-generated method stub
		return noticePaging(1,cnum);
	}

	@Override
	public int[] noticePaging(int cnum, int pnum, int page) {
		// TODO Auto-generated method stub
		
		int allCount = noticeDao.noticelist().size();
		int last = allCount/cnum+(allCount%cnum==0?0:1);
		if(page>last) page = last;
		int pagingNum=pnum*((page-1)/pnum);
		int pageLast = last-pagingNum>=pnum?pnum:last%pnum;
		return new int[]{pagingNum,pageLast,last,page};
	}

	
	
	

}
