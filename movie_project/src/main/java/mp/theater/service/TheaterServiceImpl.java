package mp.theater.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mp.theater.bean.Theater;
import mp.theater.model.TheaterDao;

@Service("theaterService")
public class TheaterServiceImpl implements TheaterService {
	@Autowired
	private TheaterDao theaterDao;
	private Logger log = LoggerFactory.getLogger(getClass());

	//영화관 등록
	@Override
	public String register(Theater theater) {
		return theaterDao.register(theater);
	}
	
	//영화관 상세 조회 (지점 입장)
	@Override
	public Theater my(String managerid) {
		return theaterDao.mytheater(managerid);
	}
	
	//영화관 수정 (지점 입장)
	@Override
	public void edit(String id, String name, String region, String address, String tel, String manager) {
		Theater t = new Theater();
		t.setId(id); t.setName(name);
		t.setRegion(region); t.setAddress(address);
		t.setTel(tel); t.setManager(manager);
		theaterDao.theateredit(t);
	}
	
	//영화관 삭제 (지점 입장)
	@Override
	public void delete(String theaterid, String sessionid, String managerpw) {
		log.debug(theaterid, sessionid, managerpw);
		theaterDao.theaterdelete(theaterid, sessionid, managerpw);
	}
	
	//영화관 목록 조회
	@Override
	public List<Theater> list() {
		return theaterDao.alltheater();
	}

	//영화관 상세 조회
	@Override
	public Theater detail(String theaterid) {
		return theaterDao.theaterdetail(theaterid);
	}
}
