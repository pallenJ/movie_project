package mp.movie.bean;
  
import java.sql.ResultSet;
import java.sql.SQLException;

public class Movie {
	private String id, title, open, close, director, actor, genre, rate; 
	private int time;
	private String nation, distributor, productor, story, posterpath, poster, postername, uploader;
	private int price;
	
	public Movie() {}
	public Movie(ResultSet rs) throws SQLException {
		setId(rs.getString("id"));
		setTitle(rs.getString("title"));
		setOpen(rs.getString("open"));
		setClose(rs.getString("close"));
		setDirector(rs.getString("director"));
		setActor(rs.getString("actor"));
		setGenre(rs.getString("genre"));
		setRate(rs.getString("rate"));
		setTime(rs.getInt("time"));
		setNation(rs.getString("nation"));
		setDistributor(rs.getString("distributor"));
		setProductor(rs.getString("productor"));
		setStory(rs.getString("story"));
		setPosterpath(rs.getString("posterpath"));
		setPoster(rs.getString("poster"));
		setPostername(rs.getString("postername"));
		setUploader(rs.getString("uploader"));
		setPrice(rs.getInt("price"));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getPosterpath() {
		return posterpath;
	}

	public void setPosterpath(String posterpath) {
		this.posterpath = posterpath;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	public String getPostername() {
		return postername;
	}
	
	public void setPostername(String postername) {
		this.postername = postername;
	}
	
	public String getUploader() {
		return uploader;
	}
	
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
