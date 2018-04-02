package mp.schedule.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import mp.schedule.bean.Schedule;
import mp.schedule.bean.ScheduleJoin;

//상영시간표관리 DAO
@Repository 
public interface ScheduleDao {

		//상영시간표 등록
		void register(Schedule schedule);
		
		//선택한 영화, 영화관, 날짜의  상영시간표 목록 조회
		List<Schedule> schedulelist(String theater, String movie, String day);
		
		//업로더별 상영시간표 목록 조회
		List<ScheduleJoin> schedulelist(String uploader);
		
		//상영시간표 상세보기
		ScheduleJoin scheduleinfo(String scheduleid);		
		
		//상영시간표 수정
		void scheduleedit(Schedule schedule);
		
		//상영시간표 삭제
		Boolean scheduledelete(String scheduleid, String sessionid, String uploaderpw);

		//상영시간표 중복 확인(중복 시간대)
		boolean check(Schedule schedule, String type);
		
		//상영시간표 등록된 날짜  가져오기(오늘부터 최신등록)
		List<String> latelydate();
		


}
