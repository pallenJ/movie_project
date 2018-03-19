package mp.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mp.movie.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/movie/register")
	public String register() {
		return "movie/register";
	}

	@RequestMapping(value="/movie/register", method=RequestMethod.POST)
	public String register(String title, String open, String close, 
			String director, String actor, String genre, String rate, String time,
			String nation, String distributor, String productor, String story, 
			String posterpath, String poster, String uploader, String price) {
		movieService.register(title, open, close, director, actor, genre, 
				rate, time, nation, distributor, productor, story, posterpath, 
				poster, uploader, price);
		return "redirect:/movie/list";
	}
	
	@RequestMapping("/movie/list")
	public String list(Model model) {
		model.addAttribute("list", movieService.getlist());
		return "movie/list";
	}
	
	@RequestMapping("/movie/edit")
	public String edit() {
		return "movie/edit";
	}
	
	@RequestMapping("movie/delete")
	public String delete() {
		return "movie/delete";
	}
	
	@RequestMapping(value= {"movie/now", "movie"})
	public String now() {
		return "movie/now";
	}
	
	@RequestMapping("movie/soon")
	public String soon() {
		return "movie/soon";
	}
	
	@RequestMapping("movie/info")
	public String info() {
		return "movie/info";
	}
}
