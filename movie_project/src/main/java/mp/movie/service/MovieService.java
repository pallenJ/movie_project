package mp.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mp.movie.bean.Movie;

@Service
public interface MovieService {
	//영화 목록 조회
	List<Movie> getlist();
	void register(String title, String open, String close, String director, 
			String actor, String genre, String rate, String time,
			String nation, String distributor, String productor, String story, 
			String posterpath, String poster, String uploader, String price);
}
