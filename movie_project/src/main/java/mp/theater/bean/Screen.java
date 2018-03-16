package mp.theater.bean;
  
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public class Screen { 
	private String id;
	private int no;
	private String theaterid;
	private int seats;
	private String uploader;
	
	public Screen() {}
	public Screen(ResultSet rs) throws SQLException {
		setId(rs.getString("id"));
		setNo(rs.getInt("no"));
		setTheaterid(rs.getString("theaterid"));
		setSeats(rs.getInt("seats"));
		setUploader(rs.getString("uploader"));
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
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
}
