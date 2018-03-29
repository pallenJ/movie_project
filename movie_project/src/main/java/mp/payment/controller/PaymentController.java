package mp.payment.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mp.member.bean.Member;
import mp.movie.bean.Movie;
import mp.movie.service.MovieService;
import mp.payment.bean.Payment;
import mp.payment.service.PaymentService;
import mp.schedule.bean.Schedule;
import mp.schedule.service.ScheduleService;
import mp.theater.bean.Theater;
import mp.theater.service.TheaterService;

@Controller
public class PaymentController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	PaymentService paymentService;	
	
	@Autowired
	TheaterService theaterService;
	
	@Autowired
	ScheduleService scheduleService;
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	ServletContext application;
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("컨트롤러");
		return "/home";
	}

//	 
	@RequestMapping("/ticket")
	public String ticket(HttpSession session, Model model) {
		String loginid = (String)session.getAttribute("loginId");
		application.setAttribute(loginid,null);	//결제대기 좌석 초기화
		List<Theater> theaterlist = theaterService.list();
		List<Movie> movielist = movieService.getNow();
		String[] datelist = {"2018-03-29","2018-03-30","2018-03-31"};
		model.addAttribute("theaterlist",theaterlist);
		model.addAttribute("movielist",movielist);
		model.addAttribute("datelist",datelist);	//오늘부터 상영스케줄 등록일까지만 출력, 일단 오늘기준 6일로 설정
		return "/ticket/ticket";
	}
	
	//ajax로 ticket schedule가져온다.
	@RequestMapping("/ticket/schedule")
	@ResponseBody
	public List<Schedule> getschedule(
			String theaterid,
			String movieid,
			String date) {
		List<Schedule> schedulelist = scheduleService.schedulelist(theaterid, movieid, date);
		return schedulelist;
	}
	
	
	@RequestMapping("/selectseat")
	public String selectseat(String theaterid, String movieid,String scheduleid, Model model) {
		model.addAttribute("theaterid", theaterid);
		model.addAttribute("movieid", movieid);
		model.addAttribute("scheduleid", scheduleid);
		return "/ticket/selectSeat";
	}	
	
	
	@RequestMapping("/payment")
	public String paymentinfo(Payment payment, 
								@RequestParam(defaultValue="0") int adult, 
								@RequestParam(defaultValue="0") int child, 
								@RequestParam(defaultValue="0") int senior,
								HttpSession session,
								Model model) {
		String loginid = (String)session.getAttribute("loginId");
		Movie movie = paymentService.getMovieInfo(payment.getMovieid());
		Member member = paymentService.getMemberInfo(loginid);					//나중에 세션에서 가져와야한다.	
		Payment paymentupdate = paymentService.setPaymentInfo(payment,movie.getPrice(),adult,child,senior);	//금액 계산하는 메소드
		model.addAttribute(paymentupdate);
		model.addAttribute(member);
		model.addAttribute(movie);
		log.debug("/payment controller paymentupdate.getPaytotal : {}",paymentupdate.getPaytotal());
		log.debug("/payment controller paymentupdate : {}",member);
		log.debug("/payment controller paymentupdate : {}",movie);
		
		boolean check = paymentService.check(paymentupdate,loginid);	//중복 여부 반납	false면 중복
		log.debug("중복확인 : {}",check);
		//중복이 아니면
		if(!check) {
			return "redirect:/ticket/fail";
		}
		return "/ticket/payment";
	}	
	
	
	@RequestMapping("/ticket/register")
	public String ticketRegister(Payment payment) throws Exception {
		log.debug("ajax넘겨온 Controller");
		log.debug("ajax넘겨온 payment payment : {}",payment.getScheduleid());
		boolean check = paymentService.register(payment);	//회원가입 성공 여부 반납
		//작동하지 않는 것인가?? ajax는 페이지 이동은 안되는 가
		if(check) {
			return "/ticket/complete";	
		}else {
			throw new Exception();
		}
	}
	
	@RequestMapping("/ticket/fail")
	public String ticketfail() {
		return "/ticket/fail";
	}
	
	@RequestMapping("/ticket/complete")
	public String ticketComplete(HttpSession session) {
		String loginid = (String)session.getAttribute("loginId");
		application.setAttribute(loginid,null);	//결제대기 좌석 초기화
		return "/ticket/complete";
	}
	
}
