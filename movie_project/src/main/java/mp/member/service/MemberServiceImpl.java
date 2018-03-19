package mp.member.service;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mp.member.bean.Member;
import mp.member.model.MemberDao;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	ServletContext servletContext;
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
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member myinfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
