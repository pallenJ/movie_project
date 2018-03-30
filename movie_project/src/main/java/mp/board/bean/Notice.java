package mp.board.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Notice {
	private int no;
	private String head;
	private String title;
	private String content;
	private String uploadPath;
	private String upload;
	private String reg; 
	private int read;
	private String writer;
	
	public Notice(ResultSet rs) throws SQLException {
		setNo(rs.getInt("no"));
		setHead(rs.getString("head"));
		setTitle(rs.getString("title"));
		setContent(rs.getString("content"));
		setUpload(rs.getString("upload"));
		setUploadPath(rs.getString("uploadpath"));
		setReg(rs.getString("reg"));
		setRead(rs.getInt("read"));
		setWriter(rs.getString("writer"));
	}
	
	public Notice() {
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}
	
		
	
	
}
