package mp.payment.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.payment.bean.Payment;

@Repository("paymentDao")
public class PaymentDaoImpl implements PaymentDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void register(Payment payment) {
		String sql ="insert into payment values ('p'||LPAD(payment_seq.nextval,'10','0'),?,?,?,?,?,?,?,?)";
		Object[] args = {
				payment.getMember(),
				payment.getMovie(),
				payment.getDay(),
				payment.getStarttime(),
				payment.getEndtime(),
				payment.getTheater(),
				payment.getScreen(),
				payment.getPrice()
		};
		jdbcTemplate.update(sql,args);
	}

	@Override
	public List<Payment> paymentlist(String membername) {
		String sql = "select * from payment where member=?";
		Object[] args = {membername};
		return jdbcTemplate.query(sql, mapper, args);
	}

	
	private RowMapper<Payment> mapper = (rs,index)->{
		return new Payment(rs);
	};
}
