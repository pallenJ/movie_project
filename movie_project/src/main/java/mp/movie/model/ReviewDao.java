package mp.movie.model;
  
import java.util.List;

import org.springframework.stereotype.Repository;

import mp.movie.bean.Review;

//리뷰&평점 관리 DAO 
@Repository
public interface ReviewDao {
	//리뷰&평점 등록
	void register(Review review);
	
	//리뷰 목록 조회(선택한 영화)
	List<Review> reviewlist(String movieid);
	
	//수정
	void reviewedit(Review review);
	
	//삭제
	void reviewdelete(String reviewid, String sessionid, String userpw);
}
