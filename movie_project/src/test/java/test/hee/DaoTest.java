package test.hee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mp.configuration.JdbcConfiguration;
import mp.member.bean.Member;
import mp.member.model.MemberDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JdbcConfiguration.class)
public class DaoTest {
	
	@Autowired
	private MemberDao memberDao;
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void insertTest() {
		Member member = new Member();
		member.setBirth("2011-01-03");
		member.setEmail("test");
		member.setId("test3");
		member.setNo("3");
		member.setPhone("123");
		member.setPw("1234");
		memberDao.register(member);
	}
}
