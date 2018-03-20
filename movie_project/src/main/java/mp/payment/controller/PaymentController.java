package mp.payment.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mp.member.bean.Member;
import mp.movie.bean.Movie;
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
	public String selectseat(String date, String theaterid, String movieid,String scheduleid, Model model) {
		model.addAttribute("date", date);
		model.addAttribute("theaterid", theaterid);
		model.addAttribute("movieid", movieid);
		model.addAttribute("scheduleid", scheduleid);
		return "/ticket/selectSeat";
	}	
	
//	@RequestMapping(value = "/selectseat", method=RequestMethod.POST)
	
	@RequestMapping("/payment")
	public String stepaymentinfo(String date, String theaterid, String movieid, String scheduleid,
			String adult, String child, String senior, String theater, String seat,
			Model model) {
		model.addAttribute("date", date);
		model.addAttribute("theaterid", theaterid);
		model.addAttribute("movieid", movieid);
		model.addAttribute("scheduleid", scheduleid);
		model.addAttribute("adult", adult);		
		model.addAttribute("child", child);		
		model.addAttribute("senior", senior);
		model.addAttribute("theater", theater);
		model.addAttribute("seat", seat);
		Movie movie = paymentService.getMovieInfo(movieid);
		Member member = paymentService.getMemberInfo("test");	//나중에 세션에서 가져와야한다.
		model.addAttribute(member);
		model.addAttribute(movie);
		return "/ticket/payment";
	}	
	
	@RequestMapping("/ticket/register")
	public String ticketRegister(String email) {
		log.debug("ajax넘겨온 email : {}",email);
//		paymentService.register(email);
		return "/ticket/complete";
	}
	
	@RequestMapping("/ticket/complete")
	public String ticketComplete() {
		return "/ticket/complete";
	}
	
}
