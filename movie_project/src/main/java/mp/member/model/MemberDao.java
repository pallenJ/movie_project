package mp.member.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import mp.member.bean.Member;

//회원관리 DAO
@Repository
public interface MemberDao {
//------ 개인 회원 ------
	//회원가입
	void register(Member member);
	
	//로그인
	boolean login(String id, String pw);
	
	//내 정보 조회
	Member myinfo(String id);
	
	//개인 정보 수정
	void edit(Member member);
	
	//탈퇴
	boolean delete(String id, String pw);
	
	//아이디 찾기
	String findid(String birth, String phone);
	
	//비밀번호 찾기
	String findpw(String id, String birth);
	
//------ 관리자 ------
	//회원목록
	List<Member> memberlist();
	
	//회원검색
	List<Member> membersearch(String sort, String keyword);
	
	//회원수정
	void adminedit(Member member);
	
	//회원삭제
	boolean admindelete(String adminpw, String memberid);

	int idCheck(String id);

	Member selectMem(String no);

}
