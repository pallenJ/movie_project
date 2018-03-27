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
public class QnaDaoImpl implements QnaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void register(Qna qna) {
		// TODO Auto-generated method stub
		String sql = "select qna_seq.nextval from dual";
		int no = jdbcTemplate.queryForObject(sql, Integer.class);
		sql = "insert into qna values(?,?,?,?,?,sysdate,0,?,?,?,0)";
		Object[] args = { no, qna.getHead(), qna.getTitle(), qna.getSecret(), qna.getContent(), qna.getWriterNo(),
				qna.getWriterId(), no };
		jdbcTemplate.update(sql, args);

	}

	@Override
	public void register(Qna qna, int parent) {
		// TODO Auto-generated method stub
		String sql = "select qna_seq.nextval from dual";
		int no = jdbcTemplate.queryForObject(sql, Integer.class);

		sql = "insert into qna values(?,?,?,?,?,sysdate,0,?,?,?,1)";
		Object[] args = { no, qna.getHead(), qna.getTitle(), qna.getSecret(), qna.getContent(), qna.getWriterNo(),
				qna.getWriterId(), parent };
		jdbcTemplate.update(sql, args);

	}

	private RowMapper<Qna> mapper = (rs, idx) -> {// return new Qna(rs);};
		Qna qna = new Qna(rs);
		return qna;
	};

	@Override
	public List<Qna> qnalist() {
		// TODO Auto-generated method stub
		String sql = "select * from qna order by parent desc, gno asc, no asc";
		List<Qna> list = jdbcTemplate.query(sql, mapper);
		return list;
	}

	private ResultSetExtractor<Qna> extractor = rs -> {// return rs.next()?new Qna(rs):null;
		if (rs.next())
			return new Qna(rs);
		else
			return null;
	};

	@Override
	public Qna qnadetail(int no) {
		// TODO Auto-generated method stub
		String sql = "select * from qna where no = ?";
		Qna qna = jdbcTemplate.query(sql, extractor, no);
		return qna;
	}

	@Override
	public void qnaedit(Qna qna) {
		// TODO Auto-generated method stub
		String sql = "update qna set head=?, title=?, content=?, secret=? where no=?";
		Object[] args = { qna.getHead(), qna.getTitle(), qna.getContent(), qna.getSecret(), qna.getNo() };
		jdbcTemplate.update(sql, args);

	}

	@Override
	public boolean qnadelete(int no, String userpw) {
		// TODO Auto-generated method stub
		// [1]qnadetail 메소드로 글정보 가져오기
		Qna qna = qnadetail(no);
		String memNo = qna.getWriterNo();
		// [2]ResultSetExtractor로 패스워드 가져오기
		String sql = "select pw from member where no=?";
		String pw = jdbcTemplate.query(sql, rs -> {
			return rs.next() ? rs.getString("pw") : null;
		}, memNo);

		// [3]패스워드가 다르거나 오류 발생시 false 반환
		if (pw == null || !pw.equals(userpw))
			return false;
		// [4] 답글이 달린 글이면 답글까지 삭제, 답글이면 답글만 삭제
		sql = "delete qna where " + (qna.getGno() == 0 ? "parent" : "no") + "=?";
		return jdbcTemplate.update(sql, no) > 0;
	}

	@Override
	public boolean qnadelete(int no) {
		// TODO Auto-generated method stub
		Qna qna = qnadetail(no);
		String sql = "delete qna where " + (qna.getGno() == 0 ? "parent" : "no") + "=?";
		return jdbcTemplate.update(sql, no) > 0;
	}

	@Override
	public List<Qna> qnaSearch(String search, String keyword) {
		String sql = "select * from qna where " + search + " like '%'||?||'%' order by parent desc, gno asc, no asc";
		List<Qna> list = jdbcTemplate.query(sql, mapper, keyword);
		return list;
	}

	@Override
	public Qna readPlus(Qna qna) {
		qna.setRead(qna.getRead() + 1);
		String sql = "update qna set read=? where no=?";
		jdbcTemplate.update(sql, qna.getRead(), qna.getNo());
		return qna;
	}

}
