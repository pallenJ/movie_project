package mp.movie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/movie/register")
	public String movie() {
		return "movie/register";
	}
}
