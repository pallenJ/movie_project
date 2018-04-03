package mp.board.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mp.board.bean.Qna;
import mp.board.model.QnaDao;
import mp.board.service.QnaService;
import mp.member.controller.MemberController;
import mp.member.model.MemberDao;

@Controller
public class QnaController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@Autowired
	private QnaService qnaService;  
	
	@Autowired
	private MemberDao memDao;
	
	@Autowired
	private QnaDao qnaDao;  
	
	@RequestMapping("/qna")
	public String qna(Model model) {
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
	public String qnaShow(Model model) {
		//비로그인 상태일시 로그인 후 글을 볼 수 있음
		String loginId = (String) session.getAttribute("loginId");
		/*if(loginId==null) {
			log.debug("먼저 로그인 하세요");
			model.addAttribute("re_login_myInfo", true);
			return "member/login";
		}*/
		
		//글번호 정보가 없을때 예외처리.(글목록으로 보냄)
		int no=Integer.parseInt(request.getParameter("no"));;
		
		//자신 이외의 사람이 글을 읽을경우 조회수 증가
		    Qna qna = qnaDao.qnadetail(no);
		    if(!loginId.equals(qna.getWriterId())) {
		    	//비밀글은 자신이나 관리자만 읽을 수 있음
		    	String grade = memDao.myinfo(loginId).getGrade();
		    	if(qna.getSecret().equals("s")&&!grade.equals("admin")&&!grade.equals("관리자")) {
		    	 log.debug("비밀글입니다");	
		    	 model.addAttribute("re_qna_secret", true);
				 return "board/qna";
		    	}
		    	qna = qnaDao.readPlus(qna);
		    }
		    
		
		model.addAttribute("contents",qna);
		log.debug(qna.toString());
		return "board/qna_show";
	}
	
	@RequestMapping(value= {"/qnaWrite","/qnawrite","/qna_write"})
	public String qnaWrite(String parent,String gno,Model model) {
		
		log.debug("parent={}",parent);
		log.debug("gno={}",gno);
		
		
		/*
		String id = (String) session.getAttribute("loginId");
		boolean flag = id!=null;
		 if(!flag) {
			log.debug("먼저 로그인 해주세요");
			model.addAttribute("re_login_myInfo", true);
			return "member/login";
		}*/
		if(parent!=null&&gno!=null) {
			request.setAttribute("parent", parent);
			request.setAttribute("gno", gno);
		}
		return "board/qna_write";
	}
	
	@RequestMapping(value= {"/qnaWrite","/qnawrite","/qna_write"},method=RequestMethod.POST)
	public String qnaWrite(String head,String title,String secret,String content,
						   String parent,String gno,Model model) {
		
		log.debug("parent={}",parent);
		log.debug("gno={}",gno);
		
		String id = (String) session.getAttribute("loginId");
		
		
		log.debug("qna id={}",id);
		/*if(id.equals("")||id==null) {
			log.debug("먼저 로그인 해주세요");
			model.addAttribute("re_login_myInfo", true);
			return "member/login";
		}*/
		if(gno!=null) {
			qnaService.qnaWrite(id, head, title, secret, content, parent);
		}else {
		qnaService.qnaWrite(id, head, title, secret, content);
		}
		return "redirect:/qna";
	}
	
	@RequestMapping(value= {"/qnaDelete","/qnadelete","/qna_delete"})
	public String qnaDelete(String no,Model model) {
		int bno = Integer.parseInt(no);
		Qna qna = qnaDao.qnadetail(bno);
		String grade = (String) session.getAttribute("loginGrade");
		model.addAttribute("re_qna", true);
		
		if(!session.getAttribute("loginId").equals(qna.getWriterId())&&!grade.equals("admin")
				&&!grade.equals("관리자")) {
		model.addAttribute("re_qna_delete", 0);	
		return "board/qna";
		}else if(grade.equals("admin")||grade.equals("관리자")) {
			if(qnaDao.qnadelete(bno)) {
				model.addAttribute("re_qna_delete", 1);
				return "board/qna";
				}else {
					model.addAttribute("re_qna_delete", 2);
				return "board/qna";
				}
		}
		model.addAttribute("re_qna_delete", 1);
		request.setAttribute("no", bno);
		return "board/qna_delete";
	}
	@RequestMapping(value= {"/qnaDelete","/qnadelete","/qna_delete"},method=RequestMethod.POST)
	public String qnaDelete(String no,String pw,Model model) {
		int bno = Integer.parseInt(no);
		boolean flag=qnaDao.qnadelete(bno, pw);
		
		log.debug("삭제"+(flag?"성공":"삭제"));
		model.addAttribute("re_qna_delete", flag?1:2);
		model.addAttribute("re_qna", true);
		return "board/qna";
	}
	
	@RequestMapping(value= {"/qnaEdit","/qnaedit","/qna_edit"})
	public String qnaEdit(String no,Model model) {
		int bno = Integer.parseInt(no);
		request.setAttribute("no", bno);
		
		Qna qna = qnaDao.qnadetail(bno);
		model.addAttribute("before",qna);
		return "board/qna_edit";
	}
	@RequestMapping(value= {"/qnaEdit","/qnaedit","/qna_edit"},method=RequestMethod.POST)
	public String qnaEdit(String no,String head,String title,String content, String secret,Model model) {
		qnaService.qnaEdit(no, head, title, content, secret);
		model.addAttribute("re_edit_qna", true);
		model.addAttribute("re_qna", true);
		return "board/qna";
	}
	
	
}
