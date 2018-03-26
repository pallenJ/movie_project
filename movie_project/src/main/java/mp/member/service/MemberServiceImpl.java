package mp.member.service;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import mp.member.bean.Member;
import mp.member.controller.MemberController;
import mp.member.model.MemberDao;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	private Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberDao memberdao;
	
	@Override
	public boolean login(String id, String pw) {
		// TODO Auto-generated method stub
		return memberdao.login(id, pw);
	}

	@Override
	public boolean loginCondition() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("loginCondition", false);
	}
	
	@Override
	public boolean exit(String id,String pw) {
		// TODO Auto-generated method stub
		return memberdao.delete(id, pw);
	}

	@Override
	public Member myinfo(String id) {
		// TODO Auto-generated method stub
		return memberdao.myinfo(id);
	}

	@Override
	public boolean register(String id, String pw, String birth, String phone, String email) {
		// TODO Auto-generated method stub
		Member member = new Member();
		
		member.setId(id);
		member.setPw(pw);
		member.setBirth(birth);
		member.setPhone(phone);
		member.setEmail(email);
		
		log.debug("result={}",member==null);
		
		try {
		memberdao.register(member);
		return true;	
		} catch (Exception e) {
		return false;
		}
	}

	@Override
	public void edit(String id,String pw, String phone, String email) {
		// TODO Auto-generated method stub
		Member member = new Member();
		
		member.setId(id);
		member.setPw(pw);
		member.setPhone(phone);
		member.setEmail(email);
		
		memberdao.edit(member);
	}


	

}
