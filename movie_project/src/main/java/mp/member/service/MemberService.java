package mp.member.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import mp.member.bean.Member;

public interface MemberService {
	   boolean login(String id, String pw);
	   boolean loginCondition();
	   void logout(Model model);
	   boolean exit(String id,String pw);
	   void edit(String id,String pw,String phone,String email);
	   Member myinfo(String id);
	   boolean register(String id, String pw, String birth, String phone, String email);
	   void message(HttpServletResponse response,String msg);
	void adminEdit(String no,  String email, String grade,String phone, String point);
}
