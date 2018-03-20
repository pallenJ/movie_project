package mp.movie.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.ParserSharedInputState;
import mp.movie.bean.Movie;
import mp.movie.model.MovieDao;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDao movieDao;
	private Logger log = LoggerFactory.getLogger(getClass());

	//영화 등록
	@Override
	public void register(String title, String open, String close, 
			String director, String actor, String genre, String rate, String time,
			String nation, String distributor, String productor, String story, 
			String posterpath, String poster, String uploader, String price) {
		Movie m = new Movie();
		m.setTitle(title); m.setOpen(open);
		m.setClose(close); m.setDirector(director);
		m.setActor(actor); m.setGenre(genre);
		m.setRate(rate); m.setTime(Integer.parseInt(time));
		m.setNation(nation); m.setDistributor(distributor);
		m.setProductor(productor); m.setStory(story);
		m.setPosterpath(posterpath); m.setPoster(poster);
		m.setUploader(uploader); m.setPrice(Integer.parseInt(price));
		movieDao.register(m);
		log.debug(title);
		log.debug("영화 등록 완료");
	}
	
	//영화 목록 조회 (영화사 입장)
	@Override
	public List<Movie> getlist() {
		return movieDao.mymovielist("member11");
	}

	//현재 개봉 영화
	@Override
	public List<Movie> getNow() {
		return movieDao.nowmovie("id");
	}

}
