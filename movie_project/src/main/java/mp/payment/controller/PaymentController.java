package mp.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mp.member.bean.Member;
import mp.movie.bean.Movie;
import mp.payment.bean.Payment;
import mp.payment.service.PaymentService;

@Controller
public class PaymentController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	PaymentService paymentService;	
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("컨트롤러");
		return "/home";
	}

//	 
	@RequestMapping("/ticket")
	public String ticket() {
		return "/ticket/ticket";
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
								Model model) {
		Payment paymentupdate = paymentService.setPaymentInfo(payment,adult,child,senior);
		Movie movie = paymentService.getMovieInfo(payment.getMovieid());
		Member member = paymentService.getMemberInfo("test");	//나중에 세션에서 가져와야한다.	
		model.addAttribute(paymentupdate);
		model.addAttribute(member);
		model.addAttribute(movie);
		log.debug("/payment controller paymentupdate.getPaytotal : {}",paymentupdate.getPaytotal());
		log.debug("/payment controller paymentupdate : {}",member);
		log.debug("/payment controller paymentupdate : {}",movie);
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
	
	@RequestMapping("/ticket/complete")
	public String ticketComplete() {
		return "/ticket/complete";
	}
	
}
