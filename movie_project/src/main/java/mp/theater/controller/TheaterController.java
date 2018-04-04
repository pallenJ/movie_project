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

import mp.theater.bean.Theater;
import mp.theater.service.TheaterService;

@Controller
public class TheaterController {
	@Autowired
	private TheaterService theaterService;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	//영화관 등록 (지점입장)
	@RequestMapping("/theater/register")
	public String register() {
		return "/theater/register";
	}
	@RequestMapping(value="/theater/register", method=RequestMethod.POST)
	public String register(String name, String region, String address, String tel, HttpSession session) {
		Theater t = new Theater();
		t.setName(name);
		t.setRegion(region);
		t.setAddress(address);
		t.setTel(tel);
		t.setManager((String)session.getAttribute("loginId"));
		String theaterid = theaterService.register(t);
		return "redirect:/theater/detail?theaterid="+theaterid;
	}
	
	//영화관 상세 조회 (지점 입장)
	@RequestMapping("/theater/my")
	public String my(HttpSession session, Model model) {
		log.debug((String)session.getAttribute("loginId"));
		Theater t = theaterService.my((String)session.getAttribute("loginId"));
		model.addAttribute("theater", t);
		return "/theater/my";
	}
	
	//영화관 수정 (지점 입장)
	@RequestMapping("/theater/edit")
	public String edit(HttpSession session, Model model) {
		model.addAttribute("theater", theaterService.my(session.getAttribute("loginId").toString()));
		return "/theater/edit";
	}
	@RequestMapping(value="/theater/edit", method=RequestMethod.POST)
	public String edit(String id, String name, String region, String address,
			String tel, String manager) {
		theaterService.edit(id, name, region, address, tel, manager);
		return "redirect:/theater/my";
	}
	
	//영화관 삭제 (지점 입장)
	@RequestMapping("/theater/delete")
	public String delete(HttpSession session, Model model) {
		model.addAttribute("theater", theaterService.my(session.getAttribute("loginId").toString()));
		return "/theater/delete";
	}
	@RequestMapping(value="/theater/delete", method=RequestMethod.POST)
	public String delete(String theaterid, String managerpw, HttpSession session) {
		theaterService.delete(theaterid, session.getAttribute("loginId").toString(), managerpw);
		return "redirect:/theater/list";
	}
	
	//영화관 목록 조회 (고객 입장)
	@RequestMapping(value= {"/theater/list", "/theater"})
	public String list(Model model) {
		List<Theater> list = theaterService.list();
		model.addAttribute("list", list);
		return "/theater/list";
	}
	
	//영화관 상세 조회 (고객 입장)
	@RequestMapping("/theater/detail")
	public String detail(String theaterid, Model model) {
		Theater t = theaterService.detail(theaterid);
		model.addAttribute("theater", t);
		return "/theater/detail";
	}
}
