package mp.theater.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mp.theater.bean.Screen;
import mp.theater.bean.Seat;
import mp.theater.service.ScreenService;
import mp.theater.service.SeatService;

@Controller
public class SeatController {
	@Autowired
	private SeatService seatService;
	@Autowired
	private ScreenService screenService;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	//좌석 등록
	@RequestMapping("/seat/register")
	public String register(HttpSession session, Model model) {
		List<Screen> screen = screenService.mylist(session.getAttribute("loginId").toString());
		model.addAttribute("screen", screen);
		return "/seat/register";
	}
	@RequestMapping(value="/seat/register", method=RequestMethod.POST)
	public String register(String seat, String screen) {
		log.debug(seat, screen);
		seatService.register(seat, screen);
		return "redirect:/seat/list";
	}
	
	//좌석 조회(리스트)
	@RequestMapping(value= {"/seat", "/seat/list"})
	public String list(HttpSession session, Model model){
		List<Screen> screen = screenService.mylist(session.getAttribute("loginId").toString());
		model.addAttribute("screen", screen);
		if(screen.size()!=0) {
			model.addAttribute("screenid", screen.get(0).getId());
		}		
		return "/seat/list";
	}
	@RequestMapping(value="/seat/list", method=RequestMethod.POST)
	@ResponseBody
	public List<Seat> list(String screenid){
		log.debug("seatlist 컨트롤러");
		List<Seat> seat = seatService.list(screenid);
		log.debug("seatlist 서비스반환");
		return seat;
	}
	
	@RequestMapping("/seat/edit")
	public String edit() {
		return "/seat/edit";
	}
	
	@RequestMapping("/seat/delete")
	public String delete() {
		return "/seat/delete";
	}
	
}
