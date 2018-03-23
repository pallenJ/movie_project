package mp.schedule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mp.schedule.bean.Schedule;
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
		boolean check = scheduleDao.check(schedule);
		if(!check) {
			throw new Exception();
		}
		scheduleDao.register(schedule);
		log.debug("scheduleservieimle register dao접근 이후");
	}

	@Override
	public List<Schedule> getlist(String uploader) {
		log.debug("scheduleservieimle getlist uploader : {}",uploader);
		List<Schedule> list = scheduleDao.schedulelist(uploader);
		log.debug("scheduleservieimle getlist uploader list내용물 하나 : {}",list.get(0).getId());		//-------지울것
		return list;
	}

}
