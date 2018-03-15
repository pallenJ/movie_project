package mp.board.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.board.bean.Qna;

//문의게시판 DAO(고객, 고객센터)
@Repository("QnaDao")
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
		
		private ResultSetExtractor<Qna> extractor= rs->{//return new Qna(rs);
			Qna qna=new Qna(rs);
			return qna;
		};
		@Override
		public void qnadetail(int no) {
		// TODO Auto-generated method stub
			String sql ="select * from qna where no = ?";
			jdbcTemplate.query(sql, mapper,no);
		}

		@Override
		public void qnaedit(Qna qna) {
		// TODO Auto-generated method stub
		
		}
	
		@Override
		public void qnadelete(int no, String userpw) {
		// TODO Auto-generated method stub
		
		}
	
	}
