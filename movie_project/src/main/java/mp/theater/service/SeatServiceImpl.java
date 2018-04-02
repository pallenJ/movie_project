package mp.theater.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mp.theater.bean.Seat;
import mp.theater.model.SeatDao;

@Service("seatService")
public class SeatServiceImpl implements SeatService {
	@Autowired
	private SeatDao seatDao;
	
	//좌석 등록
	@Override
	public void register(String seat, String screen) {
		//서비스 좌석 부여
		String[] reallocation = seat.split(",");
		String[] servicelocation = new String[reallocation.length];
		int n = 0; 
		for(char i='a'; i<'l'; i++){
			//A~L
			if(n>=reallocation.length) break;
			for(int j=1; j<=reallocation.length; j++){
				//1~23
				servicelocation[n] = String.valueOf(i)+String.valueOf(j);
				n++;
				if(n>=reallocation.length) break;
				if(!reallocation[n-1].substring(0, 1).equals(reallocation[n].substring(0, 1))) {
					break;
				}
			}
		}
		
		//좌석 리스트 추가
		List<Seat> list = new ArrayList<Seat>();
		
		for(int i=0; i<reallocation.length; i++) {
			Seat seati = new Seat();
			seati.setScreenid(screen);
			seati.setReallocation(reallocation[i]);
			seati.setServicelocation(servicelocation[i]);
			seati.setSeatdiscount(0);
			list.add(seati);
		}
		
		seatDao.register(list);
	}

	//좌석 리스트 (상세 보기)
	@Override
	public List<Seat> list(String screenid) {
		return seatDao.seatlist(screenid);
	}

	//좌석 조회 (좌석 아이디로 검색)
	@Override
	public Seat info(String seatid) {
		return seatDao.info(seatid);
	}
	
}
