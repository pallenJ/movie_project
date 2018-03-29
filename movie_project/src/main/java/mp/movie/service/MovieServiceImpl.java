package mp.movie.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mp.movie.bean.Movie;
import mp.movie.model.MovieDao;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDao movieDao;
	private Logger log = LoggerFactory.getLogger(getClass());

	//영화 등록
	@Override
	public String register(String title, String open, String close, 
			String director, String actor, String genre, String rate, String time,
			String nation, String distributor, String productor, String story, 
			String posterpath, MultipartFile poster, String uploader, String price) throws Exception {
		
		//[추가] 파일 저장하기 전에 이미지가 맞는지 검사하여 이미지가 아니면 진행을 중단
		if( 
				!poster.getOriginalFilename().endsWith(".jpg")
				&& !poster.getOriginalFilename().endsWith(".png")
				&& !poster.getOriginalFilename().endsWith(".gif")
				) {
			//return;
			throw new Exception();
		}
		String savename = UUID.randomUUID().toString();
		
		//실제로 저장하는 작업
		File dir = new File(posterpath);
		if(!dir.exists()) dir.mkdirs();
		
		File target = new File(dir, savename);
		poster.transferTo(target);
		
		//db에 추가하는 작업
		Movie m = new Movie();
		m.setTitle(title); m.setOpen(open.substring(0, 10));
		m.setClose(close.substring(0, 10)); m.setDirector(director);
		m.setActor(actor); m.setGenre(genre);
		m.setRate(rate); m.setTime(Integer.parseInt(time));
		m.setNation(nation); m.setDistributor(distributor);
		m.setProductor(productor); m.setStory(story);
		m.setPosterpath(posterpath); m.setPoster(savename);
		m.setUploader(uploader); m.setPrice(Integer.parseInt(price));
		String movieid = movieDao.register(m);
		log.debug("영화 등록 완료");
		return movieid;
	}
	
	//영화 목록 조회 (영화사 입장)
	@Override
	public List<Movie> getlist(String uploaderId) {
		return movieDao.mymovielist(uploaderId);
	}

	//영화 수정 (영화사 입장)
	@Override
	public void edit(String id, String title, String open, String close, String director, 
			String actor, String genre, String rate, String time,
			String nation, String distributor, String productor, String story, 
			String posterpath, String poster, String uploader, String price) {
		Movie m = new Movie();
		m.setId(id);
		log.debug("MovieServiceImplm id값 : "+id);
		m.setTitle(title); m.setOpen(open.substring(0, 10));
		m.setClose(close.substring(0, 10)); m.setDirector(director);
		m.setActor(actor); m.setGenre(genre);
		m.setRate(rate); m.setTime(Integer.parseInt(time));
		m.setNation(nation); m.setDistributor(distributor);
		m.setProductor(productor); m.setStory(story);
		m.setPosterpath(posterpath); m.setPoster(poster);
		m.setUploader(uploader); m.setPrice(Integer.parseInt(price));
		movieDao.edit(m);
	}
	
	//영화 삭제 (영화사 입장)
	@Override
	public void delete(String movieid, String sessionid, String uploaderpw) {
		movieDao.delete(movieid, sessionid, uploaderpw);
	}
	
	//현재 개봉 영화
	@Override
	public List<Movie> getNow() {
		return movieDao.nowmovie("id"); //id값으로 정렬
	}

	//개봉 예정 영화
	@Override
	public List<Movie> getSoon() {
		return movieDao.soonmovie("id"); //id값으로 정렬
	}

	//영화 상세 조회
	@Override
	public Movie getInfo(String movieid) {
		return movieDao.movieinfo(movieid);
	}
}
