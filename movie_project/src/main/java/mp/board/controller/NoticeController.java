package mp.board.controller;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mp.board.model.NoticeDao;
import mp.board.service.NoticeService;
import mp.member.controller.MemberController;

@Controller
public class NoticeController {
	
	private Logger log = LoggerFactory.getLogger(MemberController.class);
//	@Autowired
//	private HttpSession session;
	//HttpServletResponse response,
	
	@Autowired
	private NoticeService noticeService;  
	
	@Autowired
	private NoticeDao noticeDao;  
	
	@RequestMapping("/notice")
	public String notice(HttpServletRequest request,Model model) {
		int cnum=10;
		int pnum=10;
		
		int page=1;
		try {
			page = Integer.parseInt(request.getParameter("pg"));
		} catch (Exception e) {
			page=1;
		}
		int []addValue = noticeService.noticePaging(cnum, pnum, page);
		
		int pagingNum= addValue[0];
		int pageLast = addValue[1];
		int last     = addValue[2];
			page     = addValue[3];
		log.debug("={}",noticeDao.noticelist().size());	
		model.addAttribute("noticelist", noticeService.noticePaging(page, cnum));
		model.addAttribute("pagingNum", pagingNum);
		model.addAttribute("pageLast",  pageLast);
		model.addAttribute("lastPage",last);
		
		log.debug("page={}",page);
		log.debug("pagingNum={}",pagingNum);
		log.debug("pageLast={}",pageLast);
		log.debug("last={}",last);
		
		return "board/notice";
	}
	@RequestMapping(value={"/noticeshow","/noticeShow","/notice_show"})
	public String noticeShow(HttpServletRequest request,Model model) {
		
		int no;
		
		try {
			no=Integer.parseInt(request.getParameter("no"));
		} catch (Exception e) {
			return "board/notice";
		}
		model.addAttribute("contents",noticeDao.noticedetail(no));
		log.debug(noticeDao.noticedetail(no).toString());
		return "board/notice_show";
	}
	
	@RequestMapping(value= {"/noticeWrite","/noticewrite","/notice_write"})
	public String noticeWrite(HttpServletRequest request) {
		boolean flag = request.getParameter("loginId")!=null;
		if(!flag) {
			log.debug("먼저 로그인 해주세요");
			return "redirect:/Notice";
		}
		return "/board/notice_write";
	}
}
