package mp.schedule.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleJoin {
	private String id, movie, movietitle, theater, screen, day, starttime, endtime, uploader;
	int morning, night, screenno, seats;
	public ScheduleJoin() {
		super();
	}
	public ScheduleJoin(String id, String movie, String movietitle, String theater, String screen, String day,
			String starttime, String endtime, String uploader, int morning, int night, int screenno, int seats) {
		super();
		this.id = id;
		this.movie = movie;
		this.movietitle = movietitle;
		this.theater = theater;
		this.screen = screen;
		this.day = day;
		this.starttime = starttime;
		this.endtime = endtime;
		this.uploader = uploader;
		this.morning = morning;
		this.night = night;
		this.screenno = screenno;
		this.seats = seats;
	}




	public ScheduleJoin(ResultSet rs) throws SQLException {
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
		setMovietitle(rs.getString("movietitle"));
		setScreenno(rs.getInt("screenno"));
		setSeats(rs.getInt("seats"));
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

	public String getMovietitle() {
		return movietitle;
	}

	public void setMovietitle(String movietitle) {
		this.movietitle = movietitle;
	}

	public int getScreenno() {
		return screenno;
	}

	public void setScreenno(int screenno) {
		this.screenno = screenno;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	

	
	
	
}
