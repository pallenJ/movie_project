package mp.member.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.member.bean.Member;

//회원관리 DAO
@Repository("memberDao")	
public class MemberDaoImpl implements MemberDao{ 
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void register(Member member) {
		
		String sql="insert into member values(?,?,?,?,?,?,0,'일반',sysdate)";
		Object[] args = {member.getNo(),member.getId(),member.getPw(),
				member.getBirth(),member.getPhone(),member.getEmail()};
		
		jdbcTemplate.update(sql,args);
		
	}
	private ResultSetExtractor<Member> extractor = rs->{
//		return rs.next()?new Member(rs):null;
		if(rs.next()) return new Member(rs);
		else return null;
	};
	
	@Override
	public boolean login(String id, String pw) {
		String sql = "select * from member where id=? and pw=?";
		Member member = jdbcTemplate.query(sql,extractor,id,pw);
//		return member!=null;
		if(member==null) return false;
		else return true;
	}

	@Override
	public Member myinfo(String id) {
		String sql = "select * from member where id=?";
		Member member = jdbcTemplate.query(sql,extractor,id);
//		return member!=null;
		return member;
	}

	@Override
	public void edit(Member member) {
		//pw, phone ,email 변경가능 
		String sql = "update member set pw=?, phone=?, email=? where id=?";//id로 검색
		Object[] args = {member.getPw(),member.getPhone(),member.getEmail(),member.getId()};
		jdbcTemplate.update(sql,args);
	}

	@Override
	public boolean delete(String id, String pw) {
		String sql = "delete * from member where id=? and pw=?";
		return jdbcTemplate.update(sql,id,pw)>0;
	}

	@Override
	public String findid(String name, String birth, String phone) {
		// TODO Auto-generated method stub
		String sql = "select id from member where name=? and birth=? and phone=?";
		Object []args= {name,birth,phone};
		Member member=jdbcTemplate.query(sql, extractor,args);
		return member.getId();
	}

	@Override
	public void findpw(String id, String email, String phone) {
		// TODO Auto-generated method stub
	}
	
	private RowMapper<Member> mapper = (rs,idx)->{
		Member member = new Member(rs);
		return member;//return new Member(rs);
	};
	@Override
	public List<Member> memberlist() {
		// TODO Auto-generated method stub
		String sql ="select * from member";
		List<Member> list=jdbcTemplate.query(sql,mapper);
		return list;
	}

	@Override
	public List<Member> membersearch(String sort, String keyword) {
		// TODO Auto-generated method stub
		//sort: asc나 desc	keyword: 무엇으로 정렬할것인지
		String sql="select * from member order by ? ?";
		List<Member> list=jdbcTemplate.query(sql,mapper,sort,keyword);
		return list;
	}

	@Override
	public void adminedit(Member member) {
		// TODO Auto-generated method stub
		String sql = "update member set no=?, id=?, pw=?, "
						+"birth=?, phone=?, email=?, "
							+"point=?,grade=?, reg=? "
								+ "where no=?";
		Object []args= {member.getNo(), member.getId(), member.getPw(),
				member.getBirth(),member.getPhone(),member.getEmail(),
				member.getPoint(),member.getGrade(),member.getReg()
		};
		jdbcTemplate.update(sql, args);
	}

	@Override
	public boolean admindelete(String adminpw, String memberid) {
		// TODO Auto-generated method stub
		String sql = "delete * from member where id=? and pw=? and grade='관리자'";
		return jdbcTemplate.update(sql,adminpw,memberid)>0;
	}
	
}
