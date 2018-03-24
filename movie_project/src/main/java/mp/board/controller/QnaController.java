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
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mp.board.model.QnaDao;
import mp.board.service.QnaService;
import mp.member.controller.MemberController;

@Controller
public class QnaController {
	
	private Logger log = LoggerFactory.getLogger(MemberController.class);
//	@Autowired
//	private HttpSession session;
	//HttpServletResponse response,
	
	@Autowired
	private QnaService qnaService;  
	
	@Autowired
	private QnaDao qnaDao;  
	
	@RequestMapping("/qna")
	public String qna(HttpServletRequest request,Model model) {
		int cnum=10;
		int pnum=10;
		
		int page=1;
		try {
			page = Integer.parseInt(request.getParameter("pg"));
		} catch (Exception e) {
			page=1;
		}
		int []addValue = qnaService.qnaPaging(cnum, pnum, page);
		
		int pagingNum= addValue[0];
		int pageLast = addValue[1];
		int last     = addValue[2];
			page     = addValue[3];

		model.addAttribute("qnalist", qnaService.qnaPaging(page, cnum));
		model.addAttribute("pagingNum", pagingNum);
		model.addAttribute("pageLast",  pageLast);
		model.addAttribute("lastPage",last);
		
		log.debug("page={}",page);
		log.debug("pagingNum={}",pagingNum);
		log.debug("pageLast={}",pageLast);
		log.debug("last={}",last);
		
		return "board/qna";
	}
	@RequestMapping(value={"/qnashow","/qnaShow","/qna_show"})
	public String qnaShow(HttpServletRequest request,Model model) {
		
		int no;
		
		try {
			no=Integer.parseInt(request.getParameter("no"));
		} catch (Exception e) {
			return "board/qna";
		}
		model.addAttribute("contents",qnaDao.qnadetail(no));
		log.debug(qnaDao.qnadetail(no).toString());
		return "board/qna_show";
	}
	
	@RequestMapping(value= {"/qnaWrite","/qnawrite","/qna_write"})
	public String qnaWrite(HttpServletRequest request) {
		boolean flag = request.getParameter("loginId")!=null;
		if(!flag) {
			log.debug("먼저 로그인 해주세요");
			return "redirect:/qna";
		}
		return "/board/qna_write";
	}
}
