package mp.theater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScreenController {
	@RequestMapping("screen/register")
	public String register() {
		return "screen/register";
	}
	
	@RequestMapping("screen/detail")
	public String detail() {
		return "screen/detail";
	}
	
	@RequestMapping("screen/list")
	public String list() {
		return "screen/list";
	}
	
	@RequestMapping("screen/edit")
	public String edit() {
		return "screen/edit";
	}
	
	@RequestMapping("screen/delete")
	public String delete() {
		return "screen/delete";
	}
}
