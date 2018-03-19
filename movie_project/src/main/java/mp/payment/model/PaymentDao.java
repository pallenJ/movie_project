package mp.payment.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import mp.payment.bean.Payment;

@Repository
public interface PaymentDao {
	void register(Payment payment);
	List<Payment> paymentlist(String membername);
}
