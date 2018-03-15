package mp.theater.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import mp.theater.bean.Screen;
import mp.theater.bean.Seat;
 
@Repository("screenDao") 
public class ScreenDaoImpl implements ScreenDao {
	
	//상영관 등록
	@Override
	public void register(Seat seat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Screen screendetail(String screenid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Screen> screenlist(String theaterid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void screenedit(Screen screen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void screendelete(String screenid, String managerpw) {
		// TODO Auto-generated method stub
		
	}

}
