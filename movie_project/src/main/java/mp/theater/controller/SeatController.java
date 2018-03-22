package mp.theater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SeatController {
	@RequestMapping("/seat/register")
	public String register() {
		return "/seat/register";
	}
	
	@RequestMapping(value= {"/seat", "/seat/list"})
	public String list() {
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
}
