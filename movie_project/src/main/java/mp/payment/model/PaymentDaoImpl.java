package mp.payment.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mp.payment.bean.Payment;

@Repository("paymentDao")
public class PaymentDaoImpl implements PaymentDao {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void register(Payment payment) {
		String sql ="insert into payment values ('p'||LPAD(payment_seq.nextval,'10','0'),?,?,?,?,?,?,?,?)";
		log.debug("PaymentDaoImpl register  movieid:{}",payment.getMemberid());
		log.debug("PaymentDaoImpl register  movieid:{}",payment.getMovieid());
		log.debug("PaymentDaoImpl register  paytotal:{}",payment.getPaytotal());
		Object[] args = {
				payment.getMemberid(),
				payment.getMovieid(),
				payment.getTheaterid(),
				payment.getScreenid(),
				payment.getSeatid(),
				payment.getScheduleid(),				
				payment.getPaydate(),
				payment.getPaytotal()
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
