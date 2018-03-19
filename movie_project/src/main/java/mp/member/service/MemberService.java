package mp.member.service;

import mp.member.bean.Member;

public interface MemberService {
	   boolean login(String id, String pw);
	   boolean loginCondition();
	   void logout();
	   void exit();
	   Member myinfo();
	   
}
