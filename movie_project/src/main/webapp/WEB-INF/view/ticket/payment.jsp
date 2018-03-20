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
        	
        	//파라미터 값 불러오는 함수
        	function getParam(paramName){
	    	    var tempUrl = window.location.search.substring(1);  //url에서 처음부터 '?'까지 삭제   name=1&age=3&address=hee
	    	    console.log(tempUrl);
	    	    var tempArray = tempUrl.split('&');// '&'을 기준으로 분리하기     {"name=1","age=3","address=hee"}
	    	    console.log(tempArray);
	    	    var valueArray = new Array();
	    	    console.log(tempArray.length-1);
	    	    for(var i = 0; i<tempArray.length; i++){   
	    		  var resultArray = tempArray[i].split('=');
	    		  if(resultArray[0]==paramName){
	    			  return resultArray[1];
	    		  }
	   			}   
        	}
        	
        	//결제내역 보관 정보
        	var email = $('memberEmail').val();
        	var membername = $('#buyer_membername').val();
        	var moviename = $('#buyer_moviename').val();
        	var day = $('memberEmail').val();
        	var starttime = $('memberEmail').val();
        	var endtime = $('memberEmail').val();
        	var theater = $('memberEmail').val();
        	var screen = $('memberEmail').val();
        	var price = $('memberEmail').val(); 

        	//버튼 클릭시 결제창 출력
            $("button").on("click", function(){         	

	          	var IMP = window.IMP; // 생략가능
            	IMP.init('imp51831654'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
            	
            	IMP.request_pay({
            	    pg : 'inicis', // version 1.1.0부터 지원.
            	    pay_method : 'card',
            	    merchant_uid : 'merchant_' + new Date().getTime(),
            	    name : $('#name').val(),	//상품이름
            	    amount : 90*getParam('adult')+5000*getParam('child')+3000*getParam('senior'),
            	    buyer_email : $('#memberEmail').val(),
            	    buyer_name : '테스터',
            	    buyer_tel : $('#memberPhone').val(),
            	    buyer_addr : 'user',
            	    buyer_postcode : 'user',
            	    m_redirect_url : 'http://localhost:8080/movie_project/payment/complete'
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
                       	
            	        
            	        //ajax이용하여 결제내역 저장
            			$.ajax({
            				url:"http://localhost:8080/movie_project/ticket/register",
            				type:"get",
            				//ajax 요청을 보내면서 데이터를 첨부
            				data:{
            					email:$('#memberEmail').val()
            				},
            				dataType:"text",
            				success:function(count){
            					var c = parseInt(count);
            					console.log(c);
            					if(c > 0){
            						$("span").text("결제내역 등록 성공");
            					}
            					else if(c == 0){
            						$("span").text("결제내역 등록 실패");
            					}
            				}
            			});
            			alert('ajax완료');
                       	
	            	    }
	            	    alert(msg);
	            	    location.href = 'http://localhost:8080/movie_project/ticket/complete';	//자바스크립트 페이지 강제이동

            		});

              });
         });
    </script>

<body>
    <div>
        <h1>결제 정보 입력하기</h1>
        <h1>date: ${date}</h1>
        <h1>seat : ${seat}</h1>
        <h1>memberid : ${member.id}</h1>
 			<button>결제하기</button>
            <input type = "hidden" id="memberPhone"  value = "${member.phone}"  disabled="disabled"><br>
            <input type = "hidden" id="memberEmail"value = "${member.email}" disabled="disabled"><br>
            <input type = "hidden" id="name"  value = "${member.id}"  disabled="disabled"><br>
            <input type = "hidden" id="name"  value = "${movie.title}"  disabled="disabled"><br>
            <input type = "hidden" id="name"  value = "testdate"  disabled="disabled"><br>
            <input type = "hidden" id="name"  value = ""  disabled="disabled"><br>
            <input type = "hidden" id="name"  value = "${movie.title}"  disabled="disabled"><br>
            <input type = "hidden" id="name"  value = "${movie.title}"  disabled="disabled"><br>
            <input type = "hidden" id="name"  value = "${movie.title}"  disabled="disabled"><br>

    </div>
    <span></span>
</body> 
</html>