package mp.theater.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	//좌석 등록
	@RequestMapping("/seat/register")
	public String register(HttpSession session, Model model) {
		session.setAttribute("id", "member11"); //임의로 세션 저장
		List<Screen> screen = screenService.list(session.getAttribute("id").toString());
		model.addAttribute("screen", screen);
		return "/seat/register";
	}
	@RequestMapping(value="/seat/register", method=RequestMethod.POST)
	public String register(String seat, String screen) {
		seatService.register(seat, screen);
		return "redirect:/seat/list";
	}
	
	@RequestMapping(value= {"/seat", "/seat/list"})
	public String list(HttpSession session, Model model){
		session.setAttribute("id", "member11");
		List<Screen> screen = screenService.list(session.getAttribute("id").toString());
		model.addAttribute("screen", screen);
		return "/seat/list";
	}
	@RequestMapping(value="/seat/list")
	public String list(String screenid, HttpSession session, Model model) {
		List<Screen> screen = screenService.list(session.getAttribute("id").toString());
		List<Seat> seat = seatService.list(screenid);
		model.addAttribute("screen", screen);
		model.addAttribute("seat", seat);
		return "/seat/list";
	}
	
	@RequestMapping("/seat/edit")
	public String edit() {
		return "/seat/edit";
	}
	
	@RequestMapping("/seat/delete")
	public String delete() {
		return "/seat/delete";
	}
	
	//ajax 위한 매핑
	@RequestMapping("/seat/getscreen")
	public String getscreen() {
		
		return "";
	}
}
