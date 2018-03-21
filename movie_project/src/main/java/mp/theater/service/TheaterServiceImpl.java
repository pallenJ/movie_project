package mp.theater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mp.theater.model.TheaterDao;

@Service("theaterService")
public class TheaterServiceImpl implements TheaterService {
	@Autowired
	private TheaterDao theaterDao;

	//영화관 등록
	@Override
	public void register() {
	}
}
