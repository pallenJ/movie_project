package mp.schedule.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.schedule.bean.Schedule;
import mp.schedule.bean.ScheduleJoin;

//상영시간표 DAO IMPL


@Repository("scheduleDao") 
public class ScheduleDaoImpl implements ScheduleDao {
	
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void register(Schedule schedule) {
		String sql = "select 'd'||LPAD(schedule_seq.nextval,'10','0') from dual";
		String id = jdbcTemplate.queryForObject(sql, String.class);
		sql = "insert into schedule values(?,?,?,?,?,?,?,?,?,?)";
		Object[] args = {id,schedule.getMovie(),schedule.getTheater(),schedule.getScreen(),schedule.getDay(),schedule.getStarttime(),
						schedule.getEndtime(),schedule.getMorning(),schedule.getNight(),schedule.getUploader()};

		log.debug("scheduledaoimpl register 디비접근 직전 id : {}",id);
		log.debug("scheduledaoimpl register 디비접근 직전 uploader : {}",schedule.getUploader());
		log.debug("scheduledaoimpl register 디비접근 직전 Theater : {}",schedule.getTheater());
		log.debug("scheduledaoimpl register 디비접근 직전 starttime: {}",schedule.getStarttime());
		log.debug("scheduledaoimpl register 디비접근 직전 screen : {}",schedule.getScreen());
		log.debug("scheduledaoimpl register 디비접근 직전 night : {}",schedule.getNight());
		log.debug("scheduledaoimpl register 디비접근 직전 movie : {}",schedule.getMovie());
		log.debug("scheduledaoimpl register 디비접근 직전 morning : {}",schedule.getMorning());
		log.debug("scheduledaoimpl register 디비접근 직전 endtime : {}",schedule.getEndtime());
		log.debug("scheduledaoimpl register 디비접근 직전 day : {}",schedule.getDay());
		jdbcTemplate.update(sql,args);
	}
	
	
	@Override
	public List<Schedule> schedulelist(String theater,String movie, String day) {
		String sql = "select * from schedule where theater=? and day =? and movie=?";
		Object[] args = {theater,day,movie};
		return jdbcTemplate.query(sql, mapper,args);
	}

	@Override
	public void scheduleedit(Schedule schedule) {
		String sql = "update "
						+"schedule "
					+"set "
						+"movie=?, theater=?, screen=?, day=?, starttime=?, endtime=?, morning=?, night=? "
					+"where "+
						"id = ?";
		Object[] args = {schedule.getMovie(),schedule.getTheater(),schedule.getScreen(),schedule.getDay(),
						schedule.getStarttime(),schedule.getEndtime(),schedule.getMorning(),schedule.getNight(),
						schedule.getId()};
		jdbcTemplate.update(sql,args);
	}

	@Override
	public Boolean scheduledelete(String scheduleid, String sessionid, String uploaderpw) {
		String sql = "delete from schedule where id=? and uploader = "
					+"(select no from member where id=? and pw=?)";
		Object[] args = {scheduleid, sessionid, uploaderpw};
		return jdbcTemplate.update(sql,args)>0;
	}
	
	private RowMapper<Schedule> mapper = (rs,index)->{
		return new Schedule(rs);
	};
	
	private RowMapper<ScheduleJoin> mapperjoin = (rs,index)->{
		return new ScheduleJoin(rs);
	};
	
	
	private ResultSetExtractor<Schedule> extractor = rs->{
		if(rs.next()) {
			return new Schedule(rs);
		}else {
			return null;
		}
	};
	private ResultSetExtractor<ScheduleJoin> extractorjoin = rs->{
		if(rs.next()) {
			return new ScheduleJoin(rs);
		}else {
			return null;
		}
	};
	
	@Override
	public boolean check(Schedule schedule, String type) {
		String sql= null;
		List<Schedule> selectedlist= null;
		
		//등록일때는 id가 중복되면 안되나, 수정일 때는 id가 같을 때는 상영시간 중복되도 수정되도록 해야한다.
		if(type.equals("수정")) {
			//같은 날, 같은 상영관
			log.debug("daoimple check 수정");
			sql = "select * from schedule where day =? and screen=?and id!=?";
			Object[] args = {schedule.getDay(),schedule.getScreen(),schedule.getId()};
			selectedlist = jdbcTemplate.query(sql,mapper,args);
			
		}else {
			log.debug("daoimple check 등록");
			sql = "select * from schedule where day =? and screen=?";
			Object[] args = {schedule.getDay(),schedule.getScreen()};
			selectedlist = jdbcTemplate.query(sql,mapper,args);
		}
		//상영시간 중복 확인
		boolean check = true;
		
		//상영시작시간이 종료시간보다 늦거나 같을 때
		if(caltime(schedule.getStarttime())>=caltime(schedule.getEndtime())){
			return false;
		}
		
		for(Schedule selected: selectedlist) {
			if(caltime(schedule.getStarttime()) <= caltime(selected.getEndtime())
			   && caltime(schedule.getEndtime()) >= caltime(selected.getStarttime())	
			) {
				check = false;
				break;	//중복확인으로 break
			}
		}
		log.debug("ScheduleDaoImple check 결과 : {}",check);
		return check;
	}
	
	
	//시간 계산 메소드(01:30 -> 90)
	private int caltime(String time) {
		log.debug("시간 계산 메소드 : {} 계산 중",time);
		String[] temp = time.split(":");
		int hour = Integer.parseInt(temp[0]);
		int minute = Integer.parseInt(temp[1]);
		int result = hour*60+minute;
		log.debug("시간 계산 메소드 결과 : {}",result);
		return result;
	}


	@Override
	public List<ScheduleJoin> schedulelist(String uploader) {
		String sql ="select "
						+ "schedule.id as id, "
						+ "movie.title as movietitle, "
						+ "theater.id as theater, "
						+ "movie.id as movie, "
						+ "screen.id as screen, "
						+ "screen.no as screenno, "
						+ "screen.seats as seats, "
						+ "schedule.day as day, "
						+ "schedule.starttime as starttime, "
						+ "schedule.endtime as endtime, "
						+ "schedule.morning as morning, "
						+ "schedule.night as night, "
						+ "schedule.uploader "
					+ "from "
						+ "schedule "
					+ "join "
						+ "movie on movie.id = schedule.movie "
					+ "join "
						+ "theater on theater.id = schedule.theater "
					+ "join "
						+ "screen on screen.id = schedule.screen "
					+ "where "
						+ "schedule.uploader= "
						+ "(select no from member where id=?) "
					+ "order by day asc" ;
				
		Object[] args = {uploader};
		log.debug("ScheduleDaoImple schedulelist 작동 중 업로더 : {}",uploader);
		return jdbcTemplate.query(sql, mapperjoin, args);
	}


	@Override
	public ScheduleJoin scheduleinfo(String scheduleid) {
		String sql = "select "
				+ "schedule.id as id, "
				+ "movie.title as movietitle, "
				+ "theater.id as theater, "
				+ "movie.id as movie, "
				+ "screen.id as screen, "
				+ "screen.no as screenno, "
				+ "screen.seats as seats, "
				+ "schedule.day as day, "
				+ "schedule.starttime as starttime, "
				+ "schedule.endtime as endtime, "
				+ "schedule.morning as morning, "
				+ "schedule.night as night, "
				+ "schedule.uploader "
			+ "from "
				+ "schedule "
			+ "join "
				+ "movie on movie.id = schedule.movie "
			+ "join "
				+ "theater on theater.id = schedule.theater "
			+ "join "
				+ "screen on screen.id = schedule.screen "
			+ "where "
				+ "schedule.id=?";
		
		
		Object[] args = {scheduleid};
		log.debug("ScheduleDaoImple scheduleinfo 작동 중 scheduleid: {}",scheduleid);
		return jdbcTemplate.query(sql,extractorjoin,args);
	}


	@Override
	public List<String> latelydate() {
		String sql = "select day from schedule where day>=to_char(sysdate-1,'yyyy-mm-dd') order by day asc";	//어제 날짜부터 조회(날짜입력이 지금 달력으로 받기 때문에 sysdate로 오늘꺼 조회불가)
		return jdbcTemplate.queryForList(sql, String.class);
	}
	

}
