package mp.movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import mp.movie.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	private Logger log = LoggerFactory.getLogger(getClass());
	
	//영화 등록
	@RequestMapping("/movie/register")
	public String register() {
		return "/movie/register";
	}
	@RequestMapping(value="/movie/register", method=RequestMethod.POST)
	public String register(String title, String open, String close, 
			String director, String actor, String genre, String rate, String time,
			String nation, String distributor, String productor, String story, 
			MultipartFile poster, String uploader, String price, HttpSession session) throws Exception {
		//파일 업로드시에 pom.xml에 commons-io, commons-fileupload 추가
		//mvc-config.xml에 multipartResolver추가
		String posterpath = session.getServletContext().getRealPath("upload");
		log.debug(posterpath);
		String movieid = movieService.register(title, open, close, director, actor, genre, 
				rate, time, nation, distributor, productor, story, posterpath, poster,
				uploader, price);
		log.debug("movieService로 이동");
		return "redirect:/movie/info?movieid="+movieid;
	}
	
	//나의 영화 조회 (영화사 입장)
	@RequestMapping("/movie/list")
	public String list() {
		return "/movie/list";
	}
	@RequestMapping(value="/movie/list", method=RequestMethod.POST)
	public String list(String uploaderid, Model model) {
		model.addAttribute("list", movieService.getlist(uploaderid));
		return "/movie/list";
	}
	
	//영화 수정
	@RequestMapping("/movie/edit")
	public String edit(String movieid, Model model) {
		model.addAttribute("list", movieService.getInfo(movieid));
		return "/movie/edit";
	}
	@RequestMapping(value="/movie/edit", method=RequestMethod.POST)
	public String edit(String id, String title, String open, String close, 
			String director, String actor, String genre, String rate, String time,
			String nation, String distributor, String productor, String story, 
			String posterpath, String poster, String uploader, String price) {
		movieService.edit(id, title, open, close, director, actor, genre, 
				rate, time, nation, distributor, productor, story, posterpath, 
				poster, uploader, price);
		return "redirect:/movie/info?movieid="+id;
	}
	
	//영화 삭제
	@RequestMapping("/movie/delete")
	public String delete(String movieid, HttpSession session, Model model) {
		//일단 세션아이디 임의로 지정--------------------------------------------------------------
		session.setAttribute("id", "member11");
		model.addAttribute("movieid", movieid);
		return "/movie/delete";
	}
	@RequestMapping(value="/movie/delete", method=RequestMethod.POST)
	public String delete(String movieid, String uploaderpw, HttpSession session) {
		movieService.delete(movieid, session.getAttribute("id").toString(), uploaderpw);
		return "redirect:/movie/list";
	}
	
	//현재 개봉 영화
	@RequestMapping(value= {"/movie/now", "/movie"})
	public String now(Model model) {
		model.addAttribute("list", movieService.getNow());
		return "/movie/now";
	}
	
	//개봉 예정 영화
	@RequestMapping("/movie/soon")
	public String soon(Model model) {
		model.addAttribute("list", movieService.getSoon());
		return "/movie/soon";
	}
	
	//영화 상세 조회
	@RequestMapping("movie/info")
	public String info(String movieid, Model model) {
		model.addAttribute("movie", movieService.getInfo(movieid));
		return "movie/info";
	}
}
