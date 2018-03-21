package mp.member.service;

import org.springframework.ui.Model;

import mp.member.bean.Member;

public interface MemberService {
	   boolean login(String id, String pw);
	   boolean loginCondition();
	   void logout(Model model);
	   boolean exit(String id,String pw);
	   Member myinfo(String id);
	   boolean register(String id, String pw, String birth, String phone, String email);
	   
}
