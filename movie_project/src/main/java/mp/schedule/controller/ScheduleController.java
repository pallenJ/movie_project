package mp.schedule.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mp.member.bean.Member;
import mp.member.service.MemberService;
import mp.movie.bean.Movie;
import mp.movie.service.MovieService;
import mp.schedule.bean.Schedule;
import mp.schedule.bean.ScheduleJoin;
import mp.schedule.service.ScheduleService;
import mp.theater.bean.Screen;
import mp.theater.bean.Theater;
import mp.theater.service.ScreenService;
import mp.theater.service.TheaterService;


@Controller
public class ScheduleController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ScheduleService scheduleService;
	
	@Autowired
	MovieService movieService;

	@Autowired
	TheaterService theaterService;
	
	@Autowired
	ScreenService screenService;
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/schedule")
	public String schedulemain(HttpSession session, Model model) {
		String loginid = (String)session.getAttribute("loginId");	
		
		List<ScheduleJoin> schedulelist = scheduleService.getlist(loginid);		//세션값으로 변경해야함. 현재 id값으로 되어있다.
		
		model.addAttribute("schedulelist",schedulelist);
		return "/schedule/main";
	}
	
	
	@RequestMapping("/schedule/register")
	public String register(HttpSession session, Model model) {
		String loginid = (String)session.getAttribute("loginId");	
		Member member =memberService.myinfo(loginid);
		model.addAttribute("uploaderid",member.getNo());
		
		List<Theater> theaterlist = theaterService.list();
		List<Movie> movielist = new ArrayList<Movie>();
		movielist.addAll(movieService.getNow());
		movielist.addAll(movieService.getSoon());
		model.addAttribute("theaterlist",theaterlist);
		model.addAttribute("movielist",movielist);
		return "/schedule/register";

	}
	
	@RequestMapping(value="/schedule/register", method=RequestMethod.POST)
	public void scheduleregister(Schedule schedule) throws Exception {
		//상영시간표 등록시 영화제목, 관, 좌석수 추가해주는 메소드
		Screen screen = screenService.detail(schedule.getScreen());
		Movie movie = movieService.getInfo(schedule.getMovie());
		
		log.debug("scheduleController register : {}",schedule.getMovie());
		log.debug("scheduleController register : {}",schedule.getDay());
		scheduleService.register(schedule);
		log.debug("scheduleController register 등록 직후");
			
	}	
	
	//ajax로 영화관별 상영관 조회
	@RequestMapping("/schedule/screenlist")
	@ResponseBody
	public List<Screen> getscreenlist(String theaterid){
		log.debug("screenlist 컨트롤러 진입");
		List<Screen> screenlist = screenService.list(theaterid);
		return screenlist;		
	}
	
	
	@RequestMapping("/schedule/list")
	public String list(HttpSession session, Model model) {
		String loginid = (String)session.getAttribute("loginId");	
		List<ScheduleJoin> schedulelist = scheduleService.getlist(loginid);		//세션값으로 변경해야함. 현재 id값으로 되어있다.
		model.addAttribute("schedulelist",schedulelist);
		log.debug("scheduleController getlist return 직전");
		return "/schedule/list";
	}
	
	@RequestMapping("/schedule/info")
	public String info(String scheduleid, Model model) {
		log.debug("Controller info test");
		ScheduleJoin schedule = scheduleService.getinfo(scheduleid);
		log.debug("ScheduleController info return직전 schedule : {}",schedule);
		log.debug("ScheduleController info return직전 schedule : {}",schedule.getMovietitle());
		model.addAttribute("schedule", schedule);
		return "/schedule/info";
	}
	
	
	@RequestMapping("/schedule/edit")
	public String edit(String scheduleid, Model model) {
		ScheduleJoin schedule = scheduleService.getinfo(scheduleid);
		model.addAttribute("schedule",schedule);
		
		List<Theater> theaterlist = theaterService.list();
		List<Movie> movielist = new ArrayList<Movie>();
		movielist.addAll(movieService.getNow());
		movielist.addAll(movieService.getSoon());
		model.addAttribute("theaterlist",theaterlist);
		model.addAttribute("movielist",movielist);
		
		return "/schedule/edit";	
	}	
	
	@RequestMapping(value="/schedule/edit",method=RequestMethod.POST)
	public String editpost(Schedule schedule, HttpServletResponse response) throws IOException {
		log.debug("Controller editpost test schedule 넘어온값 : {}",schedule.getId());
		Boolean result = scheduleService.edit(schedule);
		log.debug("ScheduleController editpost 리다이렉트 직전");
		//edit후 info페이지로 이동
		if(result) {
			return "redirect:/schedule";
		}else {
			return "redirect:/schedule/editfail";
		}
	}
	
	@RequestMapping("/schedule/editfail")
	public String editfail(String model) {
		log.debug("Controller editfail test");
		return "/schedule/editfail";
	}
	
	@RequestMapping("/schedule/delete")
	public String delete(String scheduleid) {
		log.debug("Controller delete test");
		return "/schedule/delete";
	}
	
	//수정해야하마.
	@RequestMapping(value="/schedule/delete",method=RequestMethod.POST)
	public String deletepost(String scheduleid, String password, HttpSession session) throws Exception {
		String loginid = (String)session.getAttribute("loginId");
		log.debug("Controller deletepost test scheduleid : {} password : {}",scheduleid, password);
		scheduleService.delete(scheduleid,loginid,password);                                //세션변경
		log.debug("ScheduleController deletepost return직전");
		return "redirect:/schedule/list";
	}
	

		
	
}