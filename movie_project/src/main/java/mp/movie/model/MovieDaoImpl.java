package mp.movie.model;
  
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.movie.bean.Movie;

@Repository("movieDao") 
public class MovieDaoImpl implements MovieDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Logger log = LoggerFactory.getLogger(getClass());
	
	private RowMapper<Movie> mapper = (rs, index)->{
		return new Movie(rs);
	};
	
	private ResultSetExtractor<Movie> extactor = rs -> {
		if(rs.next()) {
			return new Movie(rs);
		} else {
			log.debug("데이터 없음 : null값 반환!");
			return null;
		}
	};
	
	private ResultSetExtractor<String> extractorString = rs -> {
		if(rs.next()) {
			return rs.getString(1);
		} else {
			log.debug("데이터 없음 : null값 반환!");
			return null;
		}
	};
	
	//영화 등록
	@Override
	public String register(Movie movie) {
		String sql = "select 'v'||LPAD(movie_seq.nextval, '10', '0') from dual";
		String id = jdbcTemplate.queryForObject(sql, String.class);
		sql="insert into movie values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] args = {id, movie.getTitle(), movie.getOpen(), movie.getClose(), 
				movie.getDirector(), movie.getActor(), movie.getGenre(), movie.getRate(), 
				movie.getTime(), movie.getNation(), movie.getDistributor(), 
				movie.getProductor(), movie.getStory(), movie.getPosterpath(), 
				movie.getPoster(), movie.getPostername(), movie.getUploader(), movie.getPrice()};
		jdbcTemplate.update(sql, args);
		log.debug("영화 등록 완료");
		return id;
	}

	//영화 목록 조회 (영화사 입장)
	@Override
	public List<Movie> mymovielist(String uploader) {
		String sql = "select * from movie where uploader = "
				+ "(select no from member where id=?)";
		return jdbcTemplate.query(sql, mapper, uploader);
	}

	//영화 수정
	@Override
	public void edit(Movie movie) {
		String sql = "update movie set title=?, open=?, close=?, director=?, actor=?, "
				+ "genre=?, rate=?, time=?, nation=?, distributor=?, productor=?, "
				+ "story=?, posterpath=?, poster=?, postername=?, price = ? where id = ?";
		Object[] args = {movie.getTitle(), movie.getOpen(), movie.getClose(), 
				movie.getDirector(), movie.getActor(), movie.getGenre(), movie.getRate(),
				movie.getTime(), movie.getNation(), movie.getDistributor(), 
				movie.getProductor(), movie.getStory(), movie.getPosterpath(),
				movie.getPoster(), movie.getPostername(), movie.getPrice(), movie.getId()};
		int result = jdbcTemplate.update(sql, args);
		log.debug("영화 수정 완료");
	}
	
	//영화 삭제 메소드
	@Override
	public void delete(String movieid, String sessionid, String uploaderpw) {
		String sql = "delete from movie where id = ? and uploader = " + 
				"(select no from member where id=? and pw=?)";
		log.debug(movieid);
		log.debug(sessionid);
		log.debug(uploaderpw);
		int result = jdbcTemplate.update(sql, movieid, sessionid, uploaderpw);
		if(result == 1) {
			log.debug("영화가 삭제되었습니다");
		} else {
			log.debug("영화가 삭제되지 않았습니다");
		}
	}

	//현재 상영 영화 목록 조회------------------------------------------수정필요
	@Override
	public List<Movie> nowmovie(String sort) {
		String sql = "select * from movie where open <= sysdate and "
				+ "close >= sysdate order by ? desc";
		//정렬 기준은 아직 안잡음, 평점?
		return jdbcTemplate.query(sql, mapper, sort);
	}

	//개봉 예정 영화 목록 조회------------------------------------------수정필요
	@Override
	public List<Movie> soonmovie(String sort) {
		String sql = "select * from movie where open > sysdate order "
				+ "by ? desc";
		//정렬 기준은 아직 안잡음, 평점?
		return jdbcTemplate.query(sql, mapper, sort);
	}

	//영화 상세 조회
	@Override
	public Movie movieinfo(String movieid) {
		String sql = "select * from movie where id = ?";
		return jdbcTemplate.query(sql, extactor, movieid);
	}
	
}
