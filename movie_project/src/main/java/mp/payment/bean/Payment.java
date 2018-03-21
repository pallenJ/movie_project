package mp.payment.bean;

import java.sql.ResultSet;
import java.sql.SQLException;



public class Payment {

	private String id, memberid, movieid, theaterid, screenid, seatid, scheduleid;
	private String paydate;
	private int paytotal;
	
	public Payment() {
		super();
	}
	
	public Payment(String id, String memberid, String movieid, String theaterid, String screenid, String seatid,
			String scheduleid, String paydate, int paytotal) {
		super();
		this.id = id;
		this.memberid = memberid;
		this.movieid = movieid;
		this.theaterid = theaterid;
		this.screenid = screenid;
		this.seatid = seatid;
		this.scheduleid = scheduleid;
		this.paydate = paydate;
		this.paytotal = paytotal;
	}



	public Payment(ResultSet rs) throws SQLException {
		setId(rs.getString("id"));
		setMemberid(rs.getString("memberid"));
		setMovieid(rs.getString("movieid"));
		setTheaterid(rs.getString("theaterid"));
		setScreenid(rs.getString("screenid"));
		setSeatid(rs.getString("seatid"));
		setScheduleid(rs.getString("scheduleid"));
		setPaydate(rs.getString("paydate"));
		setPaytotal(rs.getInt("paytotal"));
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMemberid() {
		return memberid;
	}


	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	public String getMovieid() {
		return movieid;
	}


	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}


	public String getTheaterid() {
		return theaterid;
	}


	public void setTheaterid(String theaterid) {
		this.theaterid = theaterid;
	}


	public String getScreenid() {
		return screenid;
	}


	public void setScreenid(String screenid) {
		this.screenid = screenid;
	}


	public String getSeatid() {
		return seatid;
	}


	public void setSeatid(String seatid) {
		this.seatid = seatid;
	}


	public String getScheduleid() {
		return scheduleid;
	}


	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}


	public String getPaydate() {
		return paydate;
	}


	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}


	public int getPaytotal() {
		return paytotal;
	}


	public void setPaytotal(int paytotal) {
		this.paytotal = paytotal;
	}
	
	
	
	
}
