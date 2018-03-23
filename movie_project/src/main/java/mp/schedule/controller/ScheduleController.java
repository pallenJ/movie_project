package mp.schedule.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mp.schedule.bean.Schedule;
import mp.schedule.service.ScheduleService;


@Controller
public class ScheduleController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ScheduleService scheduleService;
	
	@RequestMapping("/schedule")
	public String schedulemain() {
		return "/schedule/main";
	}
	
	
	@RequestMapping("/schedule/register")
	public String register() {
		return "/schedule/register";
	}
	
	@RequestMapping(value="/schedule/register", method=RequestMethod.POST)
	public void scheduleregister(Schedule schedule) throws Exception {
		log.debug("scheduleController register : {}",schedule.getMovie());
		log.debug("scheduleController register : {}",schedule.getDay());
		scheduleService.register(schedule);
		log.debug("scheduleController register 등록 직후");
	}	

	
	@RequestMapping("/schedule/list")
	public String list() {
		return "/schedule/list";
	}
}
