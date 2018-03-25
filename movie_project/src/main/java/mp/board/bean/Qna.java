package mp.board.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
create table qna 									
(no number primary key, 	
head varchar2(30) not null, 
title varchar2(150) not null, 
secret varchar2(5) not null, 
content varchar2(4000) not null, 
reg date not null, 
read number not null, 
writer constraint fk_qna_writer references member(no), 
parent number not null, 
gno number not null);
*/

public class Qna {
	
	int no;
	String head;
	String title;
	String secret;
	String content;
	String reg;
	int read;
	String writerNo;
	String writerId;
	int parent;
	int gno;
	
	public Qna(ResultSet rs) throws SQLException {
		
		setNo(rs.getInt("no"));
		setHead(rs.getString("head"));
		setTitle(rs.getString("title"));
		setSecret(rs.getString("secret"));
		setContent(rs.getString("content"));
		setReg(rs.getString("reg"));
		setRead(rs.getInt("read"));
		setWriterNo(rs.getString("writerNo"));
		setWriterId(rs.getString("writerId"));
		setParent(rs.getInt("parent")); 
		setGno(rs.getInt("gno"));
		
		}
	public Qna() {
		super();
	}
	


	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writer) {
		this.writerNo = writer;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	
	
	
	
}

/*
 (no n
head s
title s
secret s
content s
reg s
read n
writer s
parent n
gno n
 * 
 * */
