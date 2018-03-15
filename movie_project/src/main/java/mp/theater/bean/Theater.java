package mp.theater.bean;
  
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public class Theater {
	private String id, name, region, address, tel, manager;
	
	public Theater() {}
	public Theater(ResultSet rs) throws SQLException {
		setId(rs.getString("id"));
		setName(rs.getString("name"));
		setRegion(rs.getString("region"));
		setAddress(rs.getString("address"));
		setTel(rs.getString("tel"));
		setManager(rs.getString("manager"));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
}
