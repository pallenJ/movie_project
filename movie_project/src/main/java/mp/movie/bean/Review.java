package mp.movie.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public class Review {
	private String id;
	private int number;
	private String writer, content, movieid, reg;
	
	public Review() {}
	public Review(ResultSet rs) throws SQLException {
		setId(rs.getString("id"));
		setNumber(rs.getInt("number"));
		setWriter(rs.getString("writer"));
		setContent(rs.getString("content"));
		setMovieid(rs.getString("movieid"));
		setReg(rs.getString("reg"));
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
