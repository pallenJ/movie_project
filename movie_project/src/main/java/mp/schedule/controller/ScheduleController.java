package mp.schedule.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mp.movie.bean.Movie;
import mp.movie.service.MovieService;
import mp.schedule.bean.Schedule;
import mp.schedule.service.ScheduleService;
import mp.theater.bean.Screen;
import mp.theater.service.ScreenService;


@Controller
public class ScheduleController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ScheduleService scheduleService;
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	ScreenService screenService;
	
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
		//상영시간표 등록시 영화제목, 관, 좌석수 추가해주는 메소드
		Screen screen = screenService.detail(schedule.getScreen());
		Movie movie = movieService.getInfo(schedule.getMovie());
		schedule.setMovietitle(movie.getTitle());
		schedule.setScreenno(screen.getNo());
		schedule.setSeats(screen.getSeats());	
		
		
		log.debug("scheduleController register : {}",schedule.getMovie());
		log.debug("scheduleController register : {}",schedule.getDay());
		log.debug("scheduleController register : {}",schedule.getScreenno());
		log.debug("scheduleController register : {}",schedule.getSeats());
		scheduleService.register(schedule);
		log.debug("scheduleController register 등록 직후");
			
	}	

	
	@RequestMapping("/schedule/list")
	public String list(Model model) {
		List<Schedule> schedulelist = scheduleService.getlist("m0000000002");	//세션값으로 변경해야함. 현재 id값으로 되어있다.
		model.addAttribute("schedulelist",schedulelist);
		log.debug("scheduleController getlist uploader list내용물 하나 : {}",schedulelist.get(0).getMovietitle());		//-------지울것
		return "/schedule/list";
	}
	
	@RequestMapping("/schedule/info")
	public String info(String scheduleid) {
		return "/schedule/info";
	}
}
