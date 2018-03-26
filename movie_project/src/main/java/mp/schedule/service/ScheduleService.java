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

	//상영시간표 정보
	Schedule getinfo(String scheduleid);
	
	//상영시간표 수정
	Boolean edit(Schedule schedule);

	//상영시간표 삭제
	void delete(String scheduleid, String string, String password) throws Exception;
}
