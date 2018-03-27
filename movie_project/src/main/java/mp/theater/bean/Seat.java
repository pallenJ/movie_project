package mp.theater.bean;
  
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public class Seat { 
	private String id, screenid, reallocation, servicelocation;
	private int seatdiscount;
	
	public Seat() {}
	public Seat(String reallocation) {
		this.setReallocation(reallocation);
	}
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reallocation == null) ? 0 : reallocation.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		if (reallocation == null) {
			if (other.reallocation != null)
				return false;
		} else if (!reallocation.equals(other.reallocation))
			return false;
		return true;
	}
}
