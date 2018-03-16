package mp.payment.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Payment {
	private String id, movie, day, starttime, endtime, theater;
	private int screen, price;
	public Payment() {
		super();
	}
	public Payment(String id, String movie, String day, String starttime, String endtime, String theater, int screen,
			int price) {
		super();
		this.id = id;
		this.movie = movie;
		this.day = day;
		this.starttime = starttime;
		this.endtime = endtime;
		this.theater = theater;
		this.screen = screen;
		this.price = price;
	}
	
	public Payment(ResultSet rs) throws SQLException {
		setId(rs.getString("id"));
		setMovie(rs.getString("movie"));
		setDay(rs.getString("day"));
		setStarttime(rs.getString("starttime"));
		setEndtime(rs.getString("endtime"));
		setTheater(rs.getString("theater"));
		setScreen(rs.getInt("screen"));
		setPrice(rs.getInt("price"));
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	public int getScreen() {
		return screen;
	}
	public void setScreen(int screen) {
		this.screen = screen;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
