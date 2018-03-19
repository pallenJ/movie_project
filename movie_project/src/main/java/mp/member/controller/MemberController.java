package mp.member.controller;

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
	private MemberService memberservice;
	
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}

	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(Member member,Model model) {
		String id = member.getId();
		String pw = member.getPw();
		boolean loginflag=memberservice.login(id, pw);
		model.addAttribute("loginCodition", loginflag );
		log.debug("login "+(loginflag?"success":"fail"));
		return "/home";
	}

	@RequestMapping("/register")
	public String register() {
		return "member/register";
	}
	
	@RequestMapping(value = {"/myInfo","/myinfo"})//다중매핑(둘중 어느걸로 들어가도 상관 없음)
	public String myinfo() {
		return "member/myInfo";
	}
	
	
	
}
