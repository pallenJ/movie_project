package mp.theater.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import mp.theater.bean.Seat;

@Repository("seatDao") 
public class SeatDaoImpl implements SeatDao {

	@Override
	public void register(Seat seat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Seat> seatlist(String screenid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seatedit(Seat seat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seatdelete(String seatid) {
		// TODO Auto-generated method stub
		
	}

}
