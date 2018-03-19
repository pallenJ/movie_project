package mp.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PaymentController {
	
	
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
	public String stepaymentinfo(String date, String theaterid, String movieid,String scheduleid, 
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
		return "/ticket/payment";
	}	
	
	
}
