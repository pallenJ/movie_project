package mp.schedule.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import mp.schedule.bean.Schedule;

//상영시간표관리 DAO
@Repository 
public interface ScheduleDao {

		//상영시간표 등록
		void register(Schedule schedule);
		
		//영화관, 해당 날짜 영화 목록 조회
		List<Schedule> schedulelist(String theater, String day);
		
		//상영시간표 수정
		void scheduleedit(Schedule schedule);
		
		//상영시간표 삭제
		void scheduledelete(String scheduleid, String sessionid, String uploaderpw);

}
