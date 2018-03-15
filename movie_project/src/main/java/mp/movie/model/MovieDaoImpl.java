package mp.movie.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.movie.bean.Movie;

@Repository("MovieDao") 
public class MovieDaoImpl implements MovieDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Movie> mapper = (rs, index)->{
		return new Movie(rs);
	};
	
	private ResultSetExtractor<Movie> extactor;
	
	//영화 등록
	@Override
	public void register(Movie movie) {
		String sql="insert into movie values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] args = {movie.getId(), movie.getTitle(), movie.getOpen(), movie.getClose(), 
				movie.getDirector(), movie.getActor(), movie.getGenre(), movie.getRate(), 
				movie.getTime(), movie.getNation(), movie.getDistributor(), 
				movie.getProductor(), movie.getStory(), movie.getPosterpath(), 
				movie.getPoster()};
		jdbcTemplate.update(sql, args);
	}

	//영화 목록 조회
	@Override
	public List<Movie> mymovielist(String uploader) {
		String sql = "select * from movie";
		return jdbcTemplate.query(sql, mapper);
	}

	//영화 수정
	@Override
	public void edit(Movie movie) {
		String sql = "update movie set title=?, open=?, close=?, director=?, actor=?, "
				+ "genre=?, rate=?, time=?, nation=?, distributor=?, productor=?, "
				+ "story=?, posterpath=?, poster=? where id=?";
		Object[] args = {movie.getTitle(), movie.getOpen(), movie.getClose(), 
				movie.getDirector(), movie.getActor(), movie.getGenre(), movie.getRate(),
				movie.getTime(), movie.getNation(), movie.getDistributor(), 
				movie.getProductor(), movie.getStory(), movie.getPosterpath(),
				movie.getPoster(), movie.getId()};
		jdbcTemplate.update(sql, args);
	}
	
	//영화 삭제 메소드
	@Override
	public void delete(String movieid, String sessionid, String uploaderpw) {
		String sql = "delete from movie where id = ? and uploader = " + 
				"(select no from member where id='test11' and pw='test22')";
		Movie movie = jdbcTemplate.query(sql, extactor, movieid, sessionid, uploaderpw);
	}

	//현재 상영 영화 목록 조회
	@Override
	public List<Movie> nowmovie(String sort) {
		String sql = "select * from movie where open <= sysdate and "
				+ "close >= sysdate order by ? desc";
		//정렬 기준은 아직 안잡음
		return jdbcTemplate.query(sql, mapper, sort);
	}

	//개봉 예정 영화 목록 조회
	@Override
	public List<Movie> soonmovie(String sort) {
		String sql = "select * from movie where open > sysdate order by ? desc";
		//정렬 기준은 아직 안잡음
		return jdbcTemplate.query(sql, mapper, sort);
	}

	//영화 상세 조회
	@Override
	public Movie movieinfo(String movieid) {
		String sql = "select * from movie where id = ?";
		return jdbcTemplate.query(sql, extactor, movieid);
	}
	
}
