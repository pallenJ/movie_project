package mp.movie.model;
  
import java.util.List;

import org.springframework.stereotype.Repository;

import mp.movie.bean.Movie;

//영화관리 DAO 
@Repository
public interface MovieDao {
//------ 영화사 ------
	//영화 등록
	String register(Movie movie);
	
	//영화 목록 조회(영화사 입장) 
	List<Movie> mymovielist(String uploader);
	
	//영화 정보 수정
	void edit(Movie movie);
	
	//영화 삭제
	void delete(String movieid, String sessionid, String uploaderpw);
	
//------ 고객 ------
	//현재 상영 영화 조회
	List<Movie> nowmovie(String sort);
	
	//개봉 예정 영화 조회
	List<Movie> soonmovie(String sort);
	
	//영화정보(영화 1개 정보)
	Movie movieinfo(String movieid);
}
