package mp.theater.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import mp.theater.bean.Theater;

@Repository("TheaterDao") 
public class TheaterDaoImpl implements TheaterDao {

	@Override
	public void register(Theater theater) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Theater mytheater(String managerid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void theateredit(Theater theater) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void theaterdelete(String theaterid, String managerpw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Theater> alltheater() {
		// TODO Auto-generated method stub
		return null;
	}

}
