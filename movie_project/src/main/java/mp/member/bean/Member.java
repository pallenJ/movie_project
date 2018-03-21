package mp.member.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Member {

	 private String no;
	 private String id;
	 private String pw;
	 private String birth;
	 private String phone;
	 private String email;
	 private int point;
	 private String grade;	
	 private String reg;
	 
	 public Member(ResultSet rs) throws SQLException {

		 setNo(rs.getString("no"));
		 setId(rs.getString("id"));
		 setPw(rs.getString("pw"));
		 setBirth(rs.getString("birth"));
		 setPhone(rs.getString("phone"));
		 setEmail(rs.getString("email"));
		 setPoint(rs.getInt("point"));
		 setGrade(rs.getString("grade"));
		 setReg(rs.getString("reg"));
		 
	 }
 	 public Member() {
		super();
		setNo("0");
		setPoint(0);
		setGrade("normal");
		setReg("0");
	 }
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	
	 
	 
	 
	 
}
/*
 no varchar2(11) primary key, 
id varchar2(12) not null unique, 
pw varchar2(12) not null, 
birth date not null, 
phone varchar2(11) not null, 
email varchar2(50) not null, 
point number not null, 
grade varchar2(30) not null, 
reg date not null);
 * */
