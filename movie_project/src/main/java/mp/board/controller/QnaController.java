package mp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	QnaService qnaService;  
	
	@Autowired
	QnaDao qnaDao;  
	
	@RequestMapping("/qna")
	public String qna(Model model) {
		int cnum=10;
		int allCount = qnaDao.qnalist().size();
		int last = allCount/cnum;
		int pnum=10;
		int page=1;
		try {
			page = Integer.parseInt(request.getParameter("pg"));
			if(page>last) page = last;
		} catch (Exception e) {
			page=1;
		}
		model.addAttribute("qnalist", qnaService.qnaPaging(page, cnum));
		model.addAttribute("pagingNum", pnum*((page-1)/pnum));
		model.addAttribute("pageLast",((page-1)<pnum*(last/pnum)?pnum:(last%pnum
				+(allCount%pnum==0?0:1))));
		model.addAttribute("lastPage",last);
		model.addAttribute("pg",page);
		
		log.debug("page={}",last+(allCount%pnum==0?0:1));
		log.debug("page={}",page);
		log.debug("page={}",qnaService.qnaPaging(page, cnum));
		return "board/qna";
	}
	
}
