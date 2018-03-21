package mp.theater.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mp.theater.service.TheaterService;

@Controller
public class TheaterController {
	@Autowired
	private TheaterService theaterService;
	
	@RequestMapping("/theater/register")
	public String register(HttpSession session) {
		session.setAttribute("id", "member11");
		theaterService.register();
		return "/theater/register";
	}
	
	@RequestMapping("/theater/my")
	public String my() {
		return "/theater/my";
	}
	
	@RequestMapping("/theater/edit")
	public String edit() {
		return "/theater/edit";
	}
	
	@RequestMapping("/theater/delete")
	public String delete() {
		return "theater/delete";
	}
	
	@RequestMapping(value= {"/theater/list", "/theater"})
	public String list() {
		return "/theater/list";
	}
}
