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

import mp.theater.bean.Screen;
import mp.theater.bean.Theater;
import mp.theater.service.ScreenService;
import mp.theater.service.TheaterService;

@Controller
public class ScreenController {
	@Autowired
	private ScreenService screenService;
	@Autowired
	private TheaterService theaterService;
	private Logger log = LoggerFactory.getLogger(getClass());
	 
	//상영관 등록
	@RequestMapping("/screen/register")
	public String register(HttpSession session, Model model) {
		Theater theater = theaterService.my((String)session.getAttribute("loginId"));
		model.addAttribute("theater", theater);
		return "/screen/register";
	}
	@RequestMapping(value="/screen/register", method=RequestMethod.POST)
	public String register(String no, String theater, HttpSession session) {
		String screenid = screenService.register(no, theater, (String)session.getAttribute("loginId"));
		return "redirect:/screen/detail?screenid="+screenid;
	}
	
	//상영관 상세 조회
	@RequestMapping("/screen/detail")
	public String detail(String screenid, HttpSession session, Model model) {
		model.addAttribute("screen", screenService.detail(screenid));
		model.addAttribute("theater", theaterService.my(session.getAttribute("loginId").toString()));
		return "/screen/detail";
	}
	
	//상영관 목록 조회 (지점별)
	@RequestMapping(value= {"/screen/mylist", "/screen"})
	public String list(HttpSession session, Model model) {
		List<Screen> list = screenService.mylist(session.getAttribute("loginId").toString());
		model.addAttribute("list", list);
		return "/screen/mylist";
	}
	
	//상영관 수정
	@RequestMapping("/screen/edit")
	public String edit(String screenid, Model model) {
		model.addAttribute("screen", screenService.detail(screenid));
		return "/screen/edit";
	}
	@RequestMapping(value="/screen/edit", method=RequestMethod.POST)
	public String edit(String id, String no, String theaterid, String seats) {
		screenService.edit(no, theaterid, seats, id);
		return "redirect:/screen/detail?screenid="+id;
	}
	
	//상영관 삭제
	@RequestMapping("/screen/delete")
	public String delete(String screenid, Model model) {
		model.addAttribute("screenid", screenid);
		return "/screen/delete";
	}
	@RequestMapping(value="/screen/delete", method=RequestMethod.POST)
	public String delete(String screenid, String managerpw, HttpSession session) {
		log.debug(screenid, managerpw, session.getAttribute("loginId").toString());
		screenService.delete(screenid, session.getAttribute("loginId").toString(), managerpw);
		return "redirect:/screen";
	}
	
}
