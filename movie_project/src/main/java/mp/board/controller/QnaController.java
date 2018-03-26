package mp.board.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMethod;

import mp.board.bean.Qna;
import mp.board.model.QnaDao;
import mp.board.service.QnaService;
import mp.member.controller.MemberController;

@Controller
public class QnaController {
	
	private Logger log = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private HttpSession session;
	//HttpServletResponse response,
	
	@Autowired
	private QnaService qnaService;  
	
	@Autowired
	private QnaDao qnaDao;  
	
	@RequestMapping("/qna")
	public String qna(HttpServletRequest request,Model model) {
		//[1]한 페이지에 나와야 할 글의 개수, 몇개씩 페이징 할지 지정
		int cnum=10;
		int pnum=10;
		
		//[2]검색값 가져오고 검색상태인지 그냥 게시판에 들어온 상태인지 확인(search 는 내용과 제목중 무엇을 찾는지, keyword는 검색한 내용)
		//또한 필요한 변수 확인.
		String search=request.getParameter("search");
		String keyword=request.getParameter("keyword");
		boolean searchFlag=search!=null&&keyword!=null;//검색인지 아닌지 판별
		List<Qna> list;//뿌려줄 게시물들을 담을 list
		
		
		//page 값이 없으면 첫페이지로
		int page=1;
		try {
			page = Integer.parseInt(request.getParameter("pg"));
		} catch (Exception e) {
			page=1;
		}
		
		log.debug("v={}",search+","+keyword);
		//[3] 페이징 시작
		int []addValue;//여기에 필요한 결과 값 저장
		
		if(searchFlag) {//검색한 상태일때
			list=qnaService.qnaPaging(page, cnum, search, keyword);
			addValue = qnaService.qnaPaging(cnum, pnum, page, search, keyword);
		}
		else {//검색이 아닐때
			list=qnaService.qnaPaging(page, cnum);
			addValue = qnaService.qnaPaging(cnum, pnum, page);
		}
		
		//[4] Model에 값을 담아서 보내기
		model.addAttribute("qnalist", list);
		model.addAttribute("pagingNum", addValue[0]);
		model.addAttribute("pageLast",  addValue[1]);
		model.addAttribute("lastPage",  addValue[2]);
		
		/*
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
		*/
		
		return "board/qna";
	}
	@RequestMapping(value={"/qnashow","/qnaShow","/qna_show"})
	public String qnaShow(HttpServletRequest request,Model model) {
		
		if(session.getAttribute("loginId")==null) {
			log.debug("먼저 로그인 하세요");
			return "redirect:/login";
		}
		
		
		int no;
		
		try {
			no=Integer.parseInt(request.getParameter("no"));
		} catch (Exception e) {
			return "redirect:/qna";
		}
		    Qna qna = qnaDao.qnadetail(no);
		    String head = qna.getHead();
		    if(!head.contains("[")||!head.contains("]"))
			qna.setHead("["+head+"]");
		
		model.addAttribute("contents",qna);
		log.debug(qna.toString());
		return "board/qna_show";
	}
	
	@RequestMapping(value= {"/qnaWrite","/qnawrite","/qna_write"})
	public String qnaWrite(HttpServletRequest request,String parent,String gno) {
		
		log.debug("parent={}",parent);
		log.debug("gno={}",gno);
		
		
		String id = (String) session.getAttribute("loginId");
		boolean flag = id!=null;
		if(!flag) {
			log.debug("먼저 로그인 해주세요");
			return "redirect:/login";
		}
		if(parent!=null&&gno!=null) {
			request.setAttribute("parent", parent);
			request.setAttribute("gno", gno);
		}
		return "/board/qna_write";
	}
	
	@RequestMapping(value= {"/qnaWrite","/qnawrite","/qna_write"},method=RequestMethod.POST)
	public String qnaWrite(String head,String title,String secret,String content,
						   String parent,String gno) {
		
		log.debug("parent={}",parent);
		log.debug("gno={}",gno);
		
		String id = (String) session.getAttribute("loginId");
		
		if(!head.contains("[")||!head.contains("]")) {
			head = "["+head+"]";
		}
		
		log.debug("qna id={}",id);
		if(id.equals("")||id==null) {
			log.debug("먼저 로그인 해주세요");
			return "redirect:/login";
		}
		if(gno!=null) {
			qnaService.qnaWrite(id, head, title, secret, content, parent);
		}else {
		qnaService.qnaWrite(id, head, title, secret, content);
		}
		return "redirect:/qna";
	}
	
	@RequestMapping(value= {"/qnaDelete","/qnadelete","/qna_delete"})
	public String qnaDelete(HttpServletRequest request,String no) {
		int bno = Integer.parseInt(no);
		Qna qna = qnaDao.qnadetail(bno);
		
		if(!session.getAttribute("loginId").equals(qna.getWriterId())) {
		return "redirect:/qna";
		}
		request.setAttribute("no", bno);
		return "board/qna_delete";
	}
	@RequestMapping(value= {"/qnaDelete","/qnadelete","/qna_delete"},method=RequestMethod.POST)
	public String qnaDelete(HttpServletRequest request,String no,String pw) {
		int bno = Integer.parseInt(no);
		
		boolean flag=qnaDao.qnadelete(bno, pw);
		log.debug("삭제"+(flag?"성공":"삭제"));
		return "redirect:/qna";
	}
}
