package mp.schedule.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.schedule.bean.Schedule;

//상영시간표 DAO IMPL


@Repository("scheduleDao")
public class ScheduleDaoImpl implements ScheduleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void register(Schedule schedule) {
		String sql ="insert into schedule values ('d'||LPAD(schedule_seq.nextval,'10','0'),?,?,?,?,?,?,?,?,?)";
		Object[] args = {schedule.getMovie(),schedule.getTheater(),schedule.getScreen(),schedule.getDay(),schedule.getStarttime(),
						schedule.getEndtime(),schedule.getMorning(),schedule.getNight(),schedule.getUploader()};
		jdbcTemplate.update(sql,args);
	}
	
	@Override
	public List<Schedule> schedulelist(String theater, String day) {
		String sql = "select * from schedule where theater=? and day =?";
		Object[] args = {theater,day};
		return jdbcTemplate.query(sql, mapper,args);
	}

	@Override
	public void scheduleedit(Schedule schedule) {
		String sql = "update "
						+"member "
					+"set "
						+"movie=?, theater=?, screen=?, day=?, starttime=?, endtime=?, morning=?, night=?, uploader=? "
					+"where "+
						"id = ?";
		Object[] args = {schedule.getMovie(),schedule.getTheater(),schedule.getScreen(),schedule.getDay(),
						schedule.getStarttime(),schedule.getEndtime(),schedule.getMorning(),schedule.getNight(),
						schedule.getUploader(), schedule.getId()};
		jdbcTemplate.update(sql,args);
	}

	@Override
	public void scheduledelete(String scheduleid, String sessionid, String uploaderpw) {
		String sql = "delete from schedule where id=? and uploader = "
					+"(select no from member where id=? and pw=?";
		Object[] args = {sessionid,uploaderpw};
		jdbcTemplate.update(sql,args);
	}
	
	private RowMapper<Schedule> mapper = (rs,index)->{
		return new Schedule(rs);
	};
	

}
