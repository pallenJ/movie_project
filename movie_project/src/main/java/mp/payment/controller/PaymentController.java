package mp.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentController {
	@RequestMapping("/home")
	public String home() {
		System.out.println("컨트롤러");
		return "/home";
	}
	
}
