package mp.board.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.board.bean.Notice;

//공지사항 DAO
@Repository("NoticeDao")
public class NoticeDaoImpl implements NoticeDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void register(Notice notice) {
		// TODO Auto-generated method stub
		String sql = "insert into notice values(notice_seq.nextval,?,?,?,sysdate,0,?)";
		Object[] args= {notice.getHead(),notice.getTitle(),notice.getContent(),notice.getWriter()};
		jdbcTemplate.update(sql, args);
	}
	private RowMapper<Notice>mapper = (rs,idx)->{
		Notice notice = new Notice(rs);			//return new Notice(rs);
		return notice;
		};
	@Override
	public List<Notice> noticelist() {
		// TODO Auto-generated method stub
		String sql="select * from notice";
		List<Notice> list = jdbcTemplate.query(sql, mapper);
		return list;
	}
	private ResultSetExtractor<Notice> extractor=rs->{
//		return new Notice(rs);
		Notice notice = new Notice(rs);
		return notice;
	}; 
	@Override
	public Notice noticedetail(int no) {
		// TODO Auto-generated method stub
		String sql="select * from notice where no = ?";
		Notice notice = jdbcTemplate.query(sql, extractor,no);
		return notice;
	}

	@Override
	public void noticeedit(Notice notice) {
		// TODO Auto-generated method stub
		String sql="update notice set head = ? title = ? content = ? "
				+ "where no = ?";
		Object [] args = {notice.getHead(),notice.getTitle(),notice.getContent()};
		jdbcTemplate.update(sql,args);
	}

	@Override
	public boolean noticedelete(int no, String adminpw) {
		// TODO Auto-generated method stub
		
		String sql = 
		"select pw from memeber where"
		+ " no=(select writer from notice where no=?)";
		//ResultSetExtractor 사용
		
		String pw = jdbcTemplate.query(sql, rs->{return rs.getString("pw");},no);
		if(pw!=adminpw)return false;
		
		sql="delete notice where no=?";
		return jdbcTemplate.update(sql,no)>0;
	}
	
}	
