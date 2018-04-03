package mp.home.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mp.movie.bean.Movie;
import mp.movie.service.MovieService;

@Controller
public class HomeController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/home")
	public String home(Model model) {
		log.debug("home");
		List<Movie> list = movieService.getNow();
		model.addAttribute("list", list);
		return "/home";
	}
}
