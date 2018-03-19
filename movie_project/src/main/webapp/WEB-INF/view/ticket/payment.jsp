<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title></title>
</head>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    <script>
        $(document).ready(function(){
            $("button").on("click", function(){
//             	alert("테스트");
            	var IMP = window.IMP; // 생략가능
            	IMP.init('imp51831654'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
            	
            	IMP.request_pay({
            	    pg : 'inicis', // version 1.1.0부터 지원.
            	    pay_method : 'card',
            	    merchant_uid : 'merchant_' + new Date().getTime(),
            	    name : '주문명:결제테스트',
            	    amount : 14000,
            	    buyer_email : 'iamport@siot.do',
            	    buyer_name : '구매자이름',
            	    buyer_tel : '010-1234-5678',
            	    buyer_addr : '서울특별시 강남구 삼성동',
            	    buyer_postcode : '123-456',
            	    m_redirect_url : 'https://www.yourdomain.com/payments/complete'
            	}, function(rsp) {		//rsp가 뭔가요?
            	    if ( rsp.success ) {
            	        var msg = '결제가 완료되었습니다.';
            	        msg += '고유ID : ' + rsp.imp_uid;
            	        msg += '상점 거래ID : ' + rsp.merchant_uid;
            	        msg += '결제 금액 : ' + rsp.paid_amount;
            	        msg += '카드 승인번호 : ' + rsp.apply_num;
            	    } else {
            	        var msg = '결제에 실패하였습니다.';
            	        msg += '에러내용 : ' + rsp.error_msg;
            	    }
            	    alert(msg);
            	});
            });
        });
    </script>

<body>
    <div>
        <h1>결제 정보 입력하기</h1>
        <h1>date: ${date}</h1>
        <h1>seat : ${seat}</h1>
            <input type = "text" name = "cardcompony" placeholder="무슨카드"><br>
 			<button>결제하기</button>
    </div>
</body> 
</html>