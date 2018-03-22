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
            	    if ( rsp.success ) {
            	        var msg = '결제가 완료되었습니다.';
            	        msg += '고유ID : ' + rsp.imp_uid;
            	        msg += '상점 거래ID : ' + rsp.merchant_uid;
            	        msg += '결제 금액 : ' + rsp.paid_amount;
            	        msg += '카드 승인번호 : ' + rsp.apply_num;
            	        
            	        
//                	        //ajax이용하여 결제내역 저장
//             			$.ajax({
//             				url:"http://localhost:8080/movie_project/ticket/register",
//             				type:"get",
//             				//ajax 요청을 보내면서 결제내역 정보 데이터를 첨부
//             				data:{
//             						memberid:'${member.id}',
//                 					movieid:'${payment.movieid}',
//                 					theaterid:'${payment.theaterid}',
//                 					screenid:'test관',
//                 					seatid:'${payment.seatid}',
//                 					scheduleid:'${payment.scheduleid}',
//                 					paydate:'${payment.paydate}',
//             						paytotal:'${payment.paytotal}'
//             				},
//             				dataType:"text",
//             				success:function(count){
//             					var c = parseInt(count);
//             					console.log(c);
//             					if(c > 0){
//             						$("span").text("결제내역 등록 성공");
//             					}
//             					else if(c == 0){
//             						$("span").text("결제내역 등록 실패");
//             					}
//             				}
//             			});
// 	            	    alert(msg);
// 	            	    location.href = 'http://localhost:8080/movie_project/ticket/complete';	//자바스크립트 페이지 강제이동	

            	        
            	        
            	        
            	        

            	    } else {
            	        var msg = '결제에 실패하였습니다.';
            	        msg += '에러내용 : ' + rsp.error_msg;
          
            	        
            	        
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
            				},
           		        	error : function(xhr, status, error) {
         		                alert("이미 구매된 좌석이 포함되어 있어 결제를 취소합니다.");
           		       	    }
            			});
	            	   // location.href = 'http://localhost:8080/movie_project/ticket/complete';	//자바스크립트 페이지 강제이동	

            	        
            	        
            	        
            	        
            	        
            	        
            	        
	            	    }            	        
            		});
              });
         });
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