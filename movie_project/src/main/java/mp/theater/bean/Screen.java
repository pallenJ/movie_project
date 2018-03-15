package mp.theater.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public class Screen { 
	private String id;
	private int no;
	private String theaterid;
	
	public Screen() {}
	public Screen(ResultSet rs) throws SQLException {
		setId(rs.getString("id"));
		setNo(rs.getInt("no"));
		setTheaterid(rs.getString("theaterid"));
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTheaterid() {
		return theaterid;
	}
	public void setTheaterid(String theaterid) {
		this.theaterid = theaterid;
	}
}
