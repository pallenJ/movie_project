package mp.theater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TheaterController {
	@RequestMapping("theater/register")
	public String register() {
		return "theater/register";
	}
	
	@RequestMapping("theater/my")
	public String my() {
		return "theater/my";
	}
	
	@RequestMapping("theater/edit")
	public String edit() {
		return "theater/edit";
	}
	
	@RequestMapping("theater/delete")
	public String delete() {
		return "theater/delete";
	}
	
	@RequestMapping("theater/list")
	public String list() {
		return "theater/list";
	}
}
