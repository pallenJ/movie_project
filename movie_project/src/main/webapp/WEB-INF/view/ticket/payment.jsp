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
 	        //ajax이용하여 결제내역 저장
// 			$.ajax({
// 				url:"http://localhost:8080/movie_project/ticket/check",
// 				type:"get",
// 				//ajax 요청을 보내면서 결제내역 정보 데이터를 첨부
// 				data:{
// 						memberid:'${member.id}',
//     					movieid:'${payment.movieid}',
//     					theaterid:'${payment.theaterid}',
//     					screenid:'test관',
//     					seatid:'${payment.seatid}',
//     					scheduleid:'${payment.scheduleid}',
//     					paydate:'${payment.paydate}',
// 						paytotal:'${payment.paytotal}'
// 				},
// 				dataType:"text",
// 				success:function(check){
// 					if(check.trim()=="중복안됨"){
// 						alert("중복안됨");
// 					}else{
// 						alert("중복");
//     					location.href = 'http://localhost:8080/movie_project/ticket';	//자바스크립트 페이지 강제이동	
// 					}
// 				}
// 			});
 	        
 	        
 	        // 이 정보를 어플리케이션 영역에 잠시 저장하면 좋겠다. 그리고, 그 것도 중복 검사할 때 포함하면 되겠다.
 	        // s000000001의 정보가 들어있는 어플리케이션영역 이걸 사용하려면 scheduleid, seatid
 	        // 아니면 이 정보들을 디비에 잠시 넣으면 좋겠다. 등록한다. 결제대기로 그리고, 결제는 이 정보들을 삭제 	        
 	        // scheduleid, seatid같은 거.
 	        // 결제하거나, 취소하면 application영역 내용에서 삭제 
 	        
 	        
        	
            	//버튼 클릭시 결제창 출력
                $("button").on("click", function(){
                	
    	          	var IMP = window.IMP; // 생략가능
                	IMP.init('imp51831654'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
                	
                	IMP.request_pay({
                	    pg : 'inicis', // version 1.1.0부터 지원.
                	    pay_method : 'card',
                	    merchant_uid : 'merchant_' + new Date().getTime(),
                	    name : '${movie.title}',	//상품이름
                	    amount : '${payment.paytotal}',
                	    buyer_email :'${member.email}',
                	    buyer_name : '${member.id}',
                	    buyer_tel : '${member.phone}',
                	    buyer_addr : 'address',
                	    buyer_postcode : 'post',
                	    m_redirect_url : 'http://localhost:8080/movie_project/payment/complete'
                	}, function(rsp) {	
                	    if ( rsp.success ) {			//결제 성공 후.
                	        var msg = '결제가 완료되었습니다.';
                	        msg += '고유ID : ' + rsp.imp_uid;
                	        msg += '상점 거래ID : ' + rsp.merchant_uid;
                	        msg += '결제 금액 : ' + rsp.paid_amount;
                	        msg += '카드 승인번호 : ' + rsp.apply_num;

                 	        //ajax이용하여 결제내역 저장
                			$.ajax({
                				url:"http://localhost:8080/movie_project/ticket/register",
                				type:"get",
                				//ajax 요청을 보내면서 결제내역 정보 데이터를 첨부
                				data:{
                						memberid:'${member.id}',
                    					movieid:'${payment.movieid}',
                    					theaterid:'${payment.theaterid}',
                    					screenid:'test관',
                    					seatid:'${payment.seatid}',
                    					scheduleid:'${payment.scheduleid}',
                    					paydate:'${payment.paydate}',
                						paytotal:'${payment.paytotal}'
                				},
                				dataType:"text",
                				success:function(count){
                					alert(msg);
                					location.href = 'http://localhost:8080/movie_project/ticket/complete';	//자바스크립트 페이지 강제이동	
                					//console.log(c);
                				}
                			});
                	    } else {		//결제 취소 버튼 클릭시
                	        var msg = '결제를 취소하셨습니다.';
                	        alert(msg);
    	            	}            	        
                	});	//requestpay
                  });	//button
            	
         });	//ready
    </script>

<body>
    <div>
        <h1>결제 정보 입력하기</h1>
        <h1>date: ${payment.paydate}</h1>
        <h1>schedule : ${payment.scheduleid}</h1>
        <h1>seat : ${payment.seatid}</h1>
        <h1>memberid : ${member.id}</h1>
        <h1>payment.movieid : ${payment.movieid}</h1>
 			<button>결제하기</button>
    </div>
</body> 
</html>