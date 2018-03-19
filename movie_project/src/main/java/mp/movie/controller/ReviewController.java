package mp.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {
	@RequestMapping("review/register")
	public String register() {
		return "review/register";
	}
	
	@RequestMapping("review/list")
	public String list() {
		return "review/list";
	}
	
	@RequestMapping("review/edit")
	public String edit() {
		return "review/edit";
	}
	
	@RequestMapping("review/delete")
	public String delete() {
		return "review/delete";
	}
	
}
