package mp.schedule.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mp.schedule.bean.Schedule;
import mp.schedule.bean.ScheduleJoin;
import mp.schedule.model.ScheduleDao;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ScheduleDao scheduleDao;
	
	@Override
	public void register(Schedule schedule) throws Exception {
		log.debug("scheduleservieimle register : {}",schedule.getDay());
		log.debug("scheduleservieimle register : {}",schedule.getMovie());

		//등록가능여부 체크(같은날, 같은 상영관, 시작시간~종료시간 안이면 중복)
		boolean check = scheduleDao.check(schedule,"등록");
		if(!check) {
			throw new Exception();
		}
		scheduleDao.register(schedule);
		log.debug("scheduleservieimle register dao접근 이후");
	}

	@Override
	public List<ScheduleJoin> getlist(String uploader) {
		log.debug("scheduleservieimle getlist uploader : {}",uploader);
		List<ScheduleJoin> list = scheduleDao.schedulelist(uploader);
		return list;
	}

	@Override
	public ScheduleJoin getinfo(String scheduleid) {
		ScheduleJoin schedule = scheduleDao.scheduleinfo(scheduleid);
		return schedule;
	}

	@Override
	public Boolean edit(Schedule schedule) {
		log.debug("ScheduleServiceimple check");
		//등록가능여부 체크(같은날, 같은 상영관, 시작시간~종료시간 안이면 중복)
		boolean check = scheduleDao.check(schedule,"수정");
		if(!check) {
			log.debug("중복 확인 edit실패");
			return false;
		}
		scheduleDao.scheduleedit(schedule);
		log.debug("ScheduleServiceimple edit완료");
		return true;
	}

	@Override
	public void delete(String scheduleid, String id, String password) throws Exception {
		Boolean result = scheduleDao.scheduledelete(scheduleid, id, password);    
		if(!result) {
			throw new Exception();
		}
	}

	@Override
	public List<Schedule> schedulelist(String theater, String movie, String day) {
		List<Schedule> list = scheduleDao.schedulelist(theater, movie, day);
		return list;
	}

	@Override
	public List<String> getLatelydate() {
		List<String> scheduledate = scheduleDao.latelydate();
		
		//리스트 중복제거
		List<String> resultList = new ArrayList<String>();
		for (int i = 0; i < scheduledate.size(); i++) {
		    if (!resultList.contains(scheduledate.get(i))) {
		        resultList.add(scheduledate.get(i));
		    }
		}
		return resultList;
	}

}