package mp.board.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.board.bean.Notice;
import mp.board.bean.Qna;
import mp.member.controller.MemberController;

//공지사항 DAO
@Repository("noticeDao")
public class NoticeDaoImpl implements NoticeDao{
	
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void register(Notice notice) {
		// TODO Auto-generated method stub
		String sql = "select notice_seq.nextval from dual";
		int no = jdbcTemplate.queryForObject(sql, Integer.class);
		sql = "insert into notice values(?,?,?,?,?,?,sysdate,0,?)";
		Object[] args= {no,notice.getHead(),notice.getTitle(),notice.getContent(),
				notice.getUploadPath(),notice.getUpload(),notice.getWriter()};
		jdbcTemplate.update(sql, args);
	}
	private RowMapper<Notice>mapper = (rs,idx)->{
		return new Notice(rs);
		};
	@Override
	public List<Notice> noticelist() {
		// TODO Auto-generated method stub
		String sql="select * from notice order by no desc";
		List<Notice> list = jdbcTemplate.query(sql, mapper);
		return list;
	}
	
	private ResultSetExtractor<Notice> extractor=rs->{
		return rs.next()?new Notice(rs):null;
	}; 
	@Override
	public Notice noticedetail(int no) {
		// TODO Auto-generated method stub
		String sql="select * from notice where no = ?";
		Notice notice = jdbcTemplate.query(sql, extractor,no);
		return notice;
	}

	@Override
	public void noticeEdit(Notice notice) {
		// TODO Auto-generated method stub
		String sql="update notice set head = ?, title = ?, content = ?,upload=?,uploadpath=? "
				+ "where no = ?";
		Object [] args = {notice.getHead(),notice.getTitle(),notice.getContent(),notice.getUpload(),
				notice.getUploadPath(),notice.getNo()};
		jdbcTemplate.update(sql,args);
	}

	@Override
	public boolean noticedelete(int no, String adminpw) {
		// TODO Auto-generated method stub
		
		String sql = 
		"select pw from member where grade='관리자' or grade='admin'";
		//ResultSetExtractor 사용
		List<String> pws = jdbcTemplate.query(sql, (rs,idx)->{return rs.getString("pw");});
		if(!pws.contains(adminpw)) {
			log.debug("비번 불일치");
			return false;
		}
		sql="delete notice where no=?";
		return jdbcTemplate.update(sql,no)>0;
	}

	@Override
	public List<Notice> noticeSearch(String search, String keyword) {
		// TODO Auto-generated method stub
		String sql = "select * from notice where " + search + " like '%'||?||'%' order by no desc";
		List<Notice> list = jdbcTemplate.query(sql, mapper, keyword);
		return list;
	}
	@Override
	public Notice readPlus(Notice notice) {
		notice.setRead(notice.getRead() + 1);
		String sql = "update notice set read=? where no=?";
		jdbcTemplate.update(sql, notice.getRead(), notice.getNo());
		return notice;
	}
}	
