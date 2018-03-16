package mp.schedule.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Schedule {
	private String id, movie, theater, screen, day, starttime, endtime, uploader;
	int morning, night;
	public Schedule() {
		super();
	}
	
	public Schedule(String id, String movie, String theater, String screen, String day, String starttime,
			String endtime, int morning, int night, String uploader) {
		super();
		this.id = id;
		this.movie = movie;
		this.theater = theater;
		this.screen = screen;
		this.day = day;
		this.starttime = starttime;
		this.endtime = endtime;
		this.uploader = uploader;
		this.morning = morning;
		this.night = night;
	}

	public Schedule(ResultSet rs) throws SQLException {
		setId(rs.getString("id"));
		setMovie(rs.getString("movie"));
		setTheater(rs.getString("theater"));
		setScreen(rs.getString("screen"));
		setDay(rs.getString("day"));
		setStarttime(rs.getString("starttime"));
		setEndtime(rs.getString("endtime"));
		setMorning(rs.getInt("morning"));
		setNight(rs.getInt("night"));
		setUploader(rs.getString("uploader"));
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

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
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

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public int getMorning() {
		return morning;
	}

	public void setMorning(int morning) {
		this.morning = morning;
	}

	public int getNight() {
		return night;
	}

	public void setNight(int night) {
		this.night = night;
	}


	
	
	
}
