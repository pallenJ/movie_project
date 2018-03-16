package mp.theater.bean;
  
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public class Seat { 
	private String id, screenid, reallocation, servicelocation;
	private int seatdiscount;
	
	public Seat() {}
	public Seat(ResultSet rs) throws SQLException {
		setId(rs.getString("id"));
		setScreenid(rs.getString("screenid"));
		setReallocation(rs.getString("reallocation"));
		setServicelocation(rs.getString("servicelocation"));
		setSeatdiscount(rs.getInt("seatdiscount"));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getScreenid() {
		return screenid;
	}

	public void setScreenid(String screenid) {
		this.screenid = screenid;
	}

	public String getReallocation() {
		return reallocation;
	}

	public void setReallocation(String reallocation) {
		this.reallocation = reallocation;
	}

	public String getServicelocation() {
		return servicelocation;
	}

	public void setServicelocation(String servicelocation) {
		this.servicelocation = servicelocation;
	}
	
	public int getSeatdiscount() {
		return seatdiscount;
	}
	
	public void setSeatdiscount(int seatdiscount) {
		this.seatdiscount = seatdiscount;
	}
}
