package mp.movie.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mp.movie.bean.Movie;

@Service
public interface MovieService {
	//영화 등록
	String register(String title, String open, String close, String director, 
			String actor, String genre, String rate, String time,
			String nation, String distributor, String productor, String story, 
			String posterpath, MultipartFile poster, String uploader, String price) throws Exception;
	
	//영화 조회 (영화사 입장)
	List<Movie> getlist(String uploaderid);
	
	//영화 수정 (영화사 입장)
	void edit(String id, String title, String open, String close, String director, 
			String actor, String genre, String rate, String time,
			String nation, String distributor, String productor, String story, 
			String posterpath, MultipartFile poster, String postername, String uploader, String price) throws IllegalStateException, IOException, Exception;

	//영화 삭제 (영화사 입장)
	void delete(String movieid, String sessionid, String uploaderpw);
	
	//현재 개봉 영화
	List<Movie> getNow();
	
	//개봉 예정 영화
	List<Movie> getSoon();

	//영화 상세 조회
	Movie getInfo(String movieiid);

}
