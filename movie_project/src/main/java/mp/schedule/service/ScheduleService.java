package mp.schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mp.schedule.bean.Schedule;

@Service
public interface ScheduleService {

	//상영시간표 등록
	void register(Schedule schedule) throws Exception;

	//상영시간표 목록(업로더)
	List<Schedule> getlist(String uploader);

}
