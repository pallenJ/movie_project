package mp.payment.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import mp.payment.bean.Payment;

@Repository
public interface PaymentDao {
	
	//결제(예매내역) 등록 메소드
	void register(Payment payment);
	
	//기존에 예매된 좌석인지 확인하는 메소드
	boolean checkRegister(String scheduleid, String seatid);
	
	List<Payment> paymentlist(String membername);

	//결제내역 중 해당 스케줄번호 좌석id목록 불러오는 메소드
	List<String> getSeatlist(String scheduleid);
	
}
