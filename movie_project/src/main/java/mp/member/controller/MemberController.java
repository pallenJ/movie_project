package mp.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import mp.member.model.MemberDao;
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
	private MemberDao memDao;
	@Autowired
	private MemberService memberservice;
	
	@RequestMapping("/login")
	public String login(Model model) throws IOException {
		
		boolean nowLogin=false;
		try {
			nowLogin = (boolean)session.getAttribute("loginCondition");
			log.debug("login={}",nowLogin);
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(nowLogin) {
			String id = (String) session.getAttribute("loginId");
			model.addAttribute("re_login_login", true);
			log.debug("{}님이 이미 로그인 한 상태 입니다. 먼저 로그아웃 해주세요",id);	
			return "member/login";
			}
		return "member/login";
		
	}

	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(String id, String pw,Model model) {
		
		
		boolean loginflag=memberservice.login(id, pw);
		session.setAttribute("loginCondition", loginflag);
		if(!loginflag) { 
			
            model.addAttribute("re_login_fail", true);
			return "member/login";
		}
		String  grade	 =memDao.myinfo(id).getGrade();
		
		session.setAttribute("loginId", id);
		session.setAttribute("grade", grade);
		request.setAttribute("loginId", id);
		session.setAttribute("loginGrade", memberservice.myinfo(id).getGrade());
		session.setAttribute("myInfo", memberservice.myinfo(id));
		
		String msg="로그인"+(loginflag?"성공":"실패!");
		log.debug(msg);
		log.debug("id={}",id);
		model.addAttribute("re_login_home", loginflag);
		
		return "/home";
	}
//--------------------------------------------------------------------------
	@RequestMapping("/register")
	public String register() {
		return "member/register";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(String id, String pw, String birth, String phone, String email,Model model) {
		boolean flag = memberservice.register(id, pw, birth, phone, email);
		if(flag) {
		  model.addAttribute("re_reg_reg", "ok");	
		  return "/home";
		}else {
			model.addAttribute("re_reg_reg", "no");	
		return "/register";
		}
	}
//-----------------------------------------------------------------------------------------	
	@RequestMapping(value = {"/myInfo","/myinfo"})//다중매핑(둘중 어느걸로 들어가도 상관 없음)
	public String myinfo(Model model) {
		boolean nowLogin =false;
		try {
			nowLogin = (boolean)session.getAttribute("loginCondition");
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(!nowLogin) {
			log.debug("먼저 로그인 해주세요");
			model.addAttribute("re_login_myInfo", true);
			return "member/login";
			}
		
		return "member/myInfo";
	}
	@RequestMapping("/edit")
	public String edit(Model model) {
		boolean nowLogin =false;
		try {
			nowLogin = (boolean)session.getAttribute("loginCondition");
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(!nowLogin) {
			log.debug("먼저 로그인 해주세요");
			model.addAttribute("re_login_myInfo", true);
			return "member/login";
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
	public String logout(Model model) {
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
			memberservice.message(response, "정상적으로 로그아웃 되었습니다");
			log.debug("로그아웃 완료");
		} catch (Exception e) {
			memberservice.message(response, "로그아웃에 실패했습니다");
		    log.debug("로그아웃 실패");	
		}
		return "member/login";
	}
	//--------------------------------------------------------
}
