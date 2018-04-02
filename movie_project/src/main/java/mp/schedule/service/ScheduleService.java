package mp.schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mp.schedule.bean.Schedule;
import mp.schedule.bean.ScheduleJoin;

@Service
public interface ScheduleService {

	//상영시간표 등록
	void register(Schedule schedule) throws Exception;

	//상영시간표 목록(업로더)
	List<ScheduleJoin> getlist(String uploader);

	//상영시간표 정보
	ScheduleJoin getinfo(String scheduleid);
	
	//상영시간표 수정
	Boolean edit(Schedule schedule);

	//상영시간표 삭제
	void delete(String scheduleid, String id, String password) throws Exception;
	
	//선택한 영화, 영화관, 날짜의  상영시간표 목록 조회
	List<Schedule> schedulelist(String theater, String movie, String day);
	
	//상영시간표  날짜 반환(중복제거과정 포함)
	List<String> getLatelydate();
	
}
