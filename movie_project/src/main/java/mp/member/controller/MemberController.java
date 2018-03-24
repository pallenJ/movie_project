package mp.member.controller;

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

import mp.member.bean.Member;
import mp.member.service.MemberService;

@Controller
public class MemberController {
	private Logger log = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private MemberService memberservice;
	
	@RequestMapping("/login")
	public String login() {
		boolean nowLogin=false;
		try {
			nowLogin = (boolean)session.getAttribute("loginCondition");
			log.debug("login={}",nowLogin);
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(nowLogin) {
			String id = (String) session.getAttribute("loginId");	
			log.debug("{}님이 이미 로그인 한 상태 입니다. 먼저 로그아웃 해주세요",id);	
			return 	"redirect:/myInfo";
			}
		return "member/login";
	}

	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(String id, String pw) {
		
		
		boolean loginflag=memberservice.login(id, pw);
		session.setAttribute("loginCondition", loginflag);
		session.setAttribute("loginId", id);
		request.setAttribute("loginId", id);
		session.setAttribute("loginGrade", memberservice.myinfo(id).getGrade());
		session.setAttribute("myInfo", memberservice.myinfo(id));
		
		log.debug("로그인"+(loginflag?"성공":"실패!"));
		id = (String) request.getParameter("loginId");
		log.debug("id={}",id);
		return loginflag?"/home":"redirect:/login";
	}
//--------------------------------------------------------------------------
	@RequestMapping("/register")
	public String register() {
		return "member/register";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(String id, String pw, String birth, String phone, String email) {
		boolean flag = memberservice.register(id, pw, birth, phone, email);
		return flag?"/home":"redirect:/register";
	}
//-----------------------------------------------------------------------------------------	
	@RequestMapping(value = {"/myInfo","/myinfo"})//다중매핑(둘중 어느걸로 들어가도 상관 없음)
	public String myinfo() {
		boolean nowLogin =false;
		try {
			nowLogin = (boolean)session.getAttribute("loginCondition");
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(!nowLogin) {
			log.debug("먼저 로그인 해주세요");
			return "redirect:/login";
			}
		
		return "member/myInfo";
	}
	@RequestMapping("/edit")
	public String edit() {
		boolean nowLogin =false;
		try {
			nowLogin = (boolean)session.getAttribute("loginCondition");
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(!nowLogin) {
			log.debug("먼저 로그인 해주세요");
			return "redirect:/login";
			}
		return "member/edit";
	}
	
	@RequestMapping(value="edit", method=RequestMethod.POST)
	public String edit(String id,String pw,String phone,String email) {
		memberservice.edit(id, pw, phone, email);
		session.setAttribute("myInfo", memberservice.myinfo(id));
		return "member/myInfo";
	}
	
	//-----------------------------------------------
	@SuppressWarnings("deprecation")
	@RequestMapping("/logout")
	public String logout() {
		boolean flag = false;
		try {
			flag = (boolean) session.getAttribute("loginCondition");
			if(!flag) {
				log.debug("로그인상태가 아닙니다.");
				throw new Exception();
				}
			session.removeValue("loginId");
			session.removeValue("loginGrade");
			session.removeValue("loginCondition");
			session.removeValue("myInfo");
			
			log.debug("로그아웃 완료");
		} catch (Exception e) {
		    log.debug("로그아웃 실패");	
		}
		return "redirect:/login";
	}
	//--------------------------------------------------------
}
