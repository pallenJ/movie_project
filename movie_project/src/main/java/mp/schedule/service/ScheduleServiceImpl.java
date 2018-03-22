package mp.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mp.schedule.bean.Schedule;
import mp.schedule.model.ScheduleDao;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleDao scheduleDao;
	
	@Override
	public void register(Schedule schedule) {
		scheduleDao.register(schedule);
	}

}
