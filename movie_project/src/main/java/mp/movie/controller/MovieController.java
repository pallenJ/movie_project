package mp.movie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mp.movie.bean.Movie;
import mp.movie.model.MovieDao;
import mp.movie.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/movie/register")
	public String register() {
		return "movie/register";
	}
	private MovieDao movieDao;
	private Logger log = LoggerFactory.getLogger(getClass());
	@RequestMapping(value="/movie/register", method=RequestMethod.POST)
	public String register(String title, String open, String close, 
			String director, String actor, String genre, String rate, String time,
			String nation, String distributor, String productor, String story, 
			String posterpath, String poster, String uploader, String price, Model model) {
		movieService.register(title, open, close, director, actor, genre, 
				rate, time, nation, distributor, productor, story, posterpath, 
				poster, uploader, price);
		//model.addAttribute("movie", ?);
		log.debug("영화 등록 완료");
		return "redirect:info";
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
	public String now(Model model) {
		model.addAttribute("list", movieService.getNow());
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
