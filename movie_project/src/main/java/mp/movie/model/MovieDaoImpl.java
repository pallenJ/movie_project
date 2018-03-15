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
	
	//영화 등록 메소드
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

	//영화 목록 조회 메소드
	@Override
	public List<Movie> mymovielist(String uploader) {
		String sql = "select * from movie";
		return jdbcTemplate.query(sql, mapper);
	}

	//영화 수정 메소드
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
		String sql = "select pw from member where id = ?";
		Movie movie = jdbcTemplate.query(sql, extactor);
		
		//String sql = "delete from movie where id=?";
	}

	@Override
	public List<Movie> nowmovie(String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> soonmovie(String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie movieinfo(String movieid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
