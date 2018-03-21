package mp.theater.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mp.theater.bean.Screen;
import mp.theater.service.ScreenService;

@Controller
public class ScreenController {
	@Autowired
	private ScreenService screenService;
	
	//상영관 등록
	@RequestMapping("/screen/register")
	public String register(HttpSession session) {
		session.setAttribute("id", "member11"); //세션 임의로 등록
		return "/screen/register";
	}
	@RequestMapping(value="/screen/register", method=RequestMethod.POST)
	public String register(String no, String theater, String seats, String uploader) {
		String screenid = screenService.register(no, theater, seats, uploader);
		return "/redirect:/screen/detail?screenid="+screenid;
	}
	
	@RequestMapping("/screen/detail")
	public String detail(String screenid, Model model) {
		model.addAttribute("screen", screenService.detail(screenid));
		return "/screen/detail";
	}
	
	@RequestMapping(value= {"/screen/list", "/screen"})
	public String list() {
		return "/screen/list";
	}
	
	@RequestMapping("/screen/edit")
	public String edit() {
		return "/screen/edit";
	}
	
	@RequestMapping("/screen/delete")
	public String delete() {
		return "/screen/delete";
	}
}
