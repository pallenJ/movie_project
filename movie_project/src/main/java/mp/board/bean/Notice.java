package mp.board.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Notice {
	 
	
	String id;
	int star;
	String writer;
	String content;
	String movieid;
	String reg;

	
	public Notice(ResultSet rs) throws SQLException {
		setId(rs.getString("id"));
		setStar(rs.getInt("star"));
		setWriter(rs.getString("writer"));
		setContent(rs.getString("content")); 
		setMovieid(rs.getString("movieid"));
		setReg(rs.getString("reg"));
		
	}
	
	public Notice() {
		super();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	
	
	
	
}
