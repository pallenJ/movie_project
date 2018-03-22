package mp.schedule.service;

import org.springframework.stereotype.Service;

import mp.schedule.bean.Schedule;

@Service
public interface ScheduleService {

	//상영시간표 등록
	void register(Schedule schedule);

}
