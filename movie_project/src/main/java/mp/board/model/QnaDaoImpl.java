package mp.board.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.board.bean.Qna;

//문의게시판 DAO(고객, 고객센터)
@Repository("qnaDao")
public class QnaDaoImpl implements QnaDao{

		@Autowired
		private JdbcTemplate jdbcTemplate;
	
		@Override
		public void register(Qna qna) {
		// TODO Auto-generated method stub
		String sql = "insert into qna values(qna_seq.nextval,?,?,?,?,sysdate,0,?,?,?)";
		Object[] args= {qna.getHead(),  qna.getTitle(), qna.getSecret(),qna.getContent(),
						qna.getWriter(),qna.getParent(),qna.getGno()
					};
		jdbcTemplate.update(sql,args);
		
		}
		
		private RowMapper<Qna> mapper = (rs,idx)->{//return new Qna(rs);};
			Qna qna =new Qna(rs);
			return qna;
		};
		
		@Override
		public List<Qna> qnalist() {
		// TODO Auto-generated method stub
		String sql ="select * from qna order by no asc";
		List<Qna> list = jdbcTemplate.query(sql, mapper);	
		return list;
		}
		
		private ResultSetExtractor<Qna> extractor= rs->{//return rs.next()?new Qna(rs):null;
			if(rs.next()) return new Qna(rs);
			else return null;
		};
		@Override
		public Qna qnadetail(int no) {
		// TODO Auto-generated method stub
			String sql ="select * from qna where no = ?";
			Qna qna= jdbcTemplate.query(sql, extractor,no);
			return qna;
		}

		@Override
		public void qnaedit(Qna qna) {
		// TODO Auto-generated method stub
			String sql = "update qna set head=?, title=?, secret=? where no=?";
			Object [] args = {qna.getHead(), qna.getTitle(), qna.getSecret(),qna.getNo()};
			jdbcTemplate.update(sql,args);
		
		}
	
		@Override
		public boolean qnadelete(int no, String userpw) {
		// TODO Auto-generated method stub
			//[1]qnadetail 메소드로 글정보 가져오기
			Qna qna = qnadetail(no);
			String memNo = qna.getWriter();
			//[2]ResultSetExtractor로 패스워드 가져오기
			String sql = "select pw from member where no=?";
			String pw = jdbcTemplate.query(sql, rs->{
			return rs.next()?rs.getString("pw"):null;}
			,memNo);
			
			//[3]패스워드가 다르거나 오류 발생시 false 반환
			if(pw==null||!pw.equals(userpw))
			return false;
			sql= "delete qna where no=?";
			return jdbcTemplate.update(sql,no)>0;
		}
	
	}
