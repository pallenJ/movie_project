package mp.board.controller;


import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;

import mp.board.bean.Notice;
import mp.board.model.NoticeDao;
import mp.board.service.NoticeService;
import mp.member.bean.Member;
import mp.member.model.MemberDao;

@Controller
public class NoticeController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
//	@Autowired
//	private HttpSession session;
	//HttpServletResponse response,
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	private NoticeService noticeService;  
	
	@Autowired
	private NoticeDao noticeDao;  
  
	
	@RequestMapping("/notice")
	public String notice(Model model) {
		int cnum=10;
		int pnum=10;
		
		
		String search=request.getParameter("search");
		String keyword=request.getParameter("keyword");
		boolean searchFlag=search!=null&&keyword!=null;//검색인지 아닌지 판별
		List<Notice> list;
		
		int page=1;
		try {
			page = Integer.parseInt(request.getParameter("pg"));
		} catch (Exception e) {
			page=1;
		}
		
		
		int []addValue;;
		if(searchFlag) {//검색한 상태일때
			list=noticeService.noticePaging(page, cnum, search, keyword);
			addValue = noticeService.noticePaging(cnum, pnum, page, search, keyword);
		}
		else {//검색이 아닐때
			list=noticeService.noticePaging(page, cnum);
			addValue = noticeService.noticePaging(cnum, pnum, page);
		}
		
		int pagingNum= addValue[0];
		int pageLast = addValue[1];
		int last     = addValue[2];
			page     = addValue[3];
		
		
		model.addAttribute("noticelist",list);
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
	public String noticeShow(Model model) {
		
		int no;
		try {
			no=Integer.parseInt(request.getParameter("no"));
		} catch (Exception e) {
			return "redirect:/notice";
		}
		
		String grade = (String)session.getAttribute("loginGrade");
		boolean adminFlag;
		try {
			adminFlag=grade.equals("관리자")||grade.equals("admin");
		} catch (Exception e) {
			adminFlag = false;
		}
		Notice notice = noticeDao.noticedetail(no);
		
		/*if(id==null||id=="") {
			model.addAttribute("contents",notice);
//			log.debug(noticeDao.noticedetail(no).toString());
			return "board/notice_show";
		}*/
		if(!adminFlag) {	
		notice=noticeDao.readPlus(notice);
		}
		model.addAttribute("contents",notice);
		
		
//		log.debug(noticeDao.noticedetail(no).toString());
		return "board/notice_show";
	}
	
	@RequestMapping(value= {"/noticeWrite","/noticewrite","/notice_write"})
	public String noticeWrite(Model model) {
		/*String id = (String) session.getAttribute("loginId");
		String grade = (String) session.getAttribute("loginGrade");
		boolean flag = id!=null;
		if(!flag) {
			log.debug("먼저 로그인 해주세요");
			model.addAttribute("re_login_myInfo", true);
			return "member/login";
		}else if(!grade.equals("admin")&&!grade.equals("관리자")) {
			log.debug("권한이 부족합니다.");
			model.addAttribute("re_no_no", true);
			return "board/notice";
		}*/
		  
		return "board/notice_write";
	}

	@RequestMapping(value= {"/noticeWrite","/noticewrite","/notice_write"}, method = RequestMethod.POST)
	public String noticeWrite(String head, String title,String content,MultipartFile upload, Model model) {
		String uploadPath = session.getServletContext().getRealPath("upload");
		String id = (String) session.getAttribute("loginId");
		
		log.debug("upload = {}",upload.toString());
		
		if(upload!=null) {
		String result;
		try {
			result=noticeService.noticeWrite(id, head, title, content,uploadPath,upload);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result="fail";
		}
		log.debug("rs={}",result);
		}/*else {
			noticeService.noticeWrite(id, head, title, content);
		}*/
		model.addAttribute("re_no", true);
		
		return "board/notice";
	}
	
	@RequestMapping(value= {"/noticeDelete","/noticedelete","/notice_delete"})
	public String noticeDelete(String no,Model model) {
		/*try {*/
			
		/*String grade = (String) session.getAttribute("loginGrade");*/
		
		/*if(!grade.equals("admin")&&!grade.equals("관리자")) throw new Exception();*/
		request.setAttribute("no", Integer.parseInt(no));
		return "board/notice_delete";
		/*} catch (Exception e) {
			log.debug("권한이 부족합니다.");
			model.addAttribute("re_no_no", true);
			return "board/notice";
		}*/
	}
	
	@RequestMapping(value= {"/noticeDelete","/noticedelete","/notice_delete"}, method = RequestMethod.POST)
	public String noticeDelete(String no,String pw,Model model) {
		
		int bno = Integer.parseInt(no);
		Notice notice =noticeDao.noticedetail(bno);
		String upload = notice.getUpload();
		log.debug("del path={}",upload);
		boolean flag1=false;
		if(upload!=null&&!upload.equals("")) {
			String uploadPath = notice.getUploadPath();
			flag1=noticeService.fileDelete(uploadPath,upload);
		}
		
		log.debug("file delete={}",flag1?"success":"fail");
		boolean flag2=noticeDao.noticedelete(bno, pw);
		
		log.debug("no={}",bno);
		log.debug("pw={}",pw);
		log.debug("삭제"+(flag2?"성공":"실패"));
		model.addAttribute("re_no_delete", true);
		return "board/notice";
	}
	
	@RequestMapping(value= {"/noticeEdit","/noticeedit","/notice_edit"})
	public String noticeEdit(String no,String fileDelete,Model model) {
		log.debug("fileEdit={}",fileDelete);
		/*try {*/
//		String grade = (String) session.getAttribute("loginGrade");
		
		int bno = Integer.parseInt(no);
		Notice notice = noticeDao.noticedetail(bno);
		log.debug("content = {}",notice.getContent());
		model.addAttribute("before",notice);
		return "board/notice_edit";
		/*}catch (Exception e) {
			log.debug("권한이 부족합니다.");
			model.addAttribute("re_no_no", true);
			return "board/notice";
		}*/
		
	}
	
	@RequestMapping(value={"/noticeEdit","/noticeedit","/notice_edit"},method = RequestMethod.POST)
	public String noticeEdit(String no,String head,String title,String content,String fileDelete,MultipartFile newfile,Model model) {
		try {
			String uploadPath = session.getServletContext().getRealPath("upload");
			noticeService.noticeEdit(no, head, title, content,fileDelete,uploadPath,newfile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		request.setAttribute("no", no);
		return "board/notice";
	}
	
}
