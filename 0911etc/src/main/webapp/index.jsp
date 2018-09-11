<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<!-- 인코딩 설정 -->
<meta charset="utf-8" />
<title>JSP 기타</title>
</head>
<body>
	<a href="mailsend.do">메일 보내기</a>
	<br />
	<input type="button" id="proxy" value="proxy 사용" />
	<input type="button" id="push" value="push 시작" />
	<div id="disp"></div>
	닉네임<input type="text" id ="nick" size"30"/><br/> 
	보낼내용<input type="text" id="message" size="50"/><br/>
	<input type="button" id="send" value="보내기"/><br/>
	받은내용<textarea id="print"rows="15" cols="80"></textarea>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="resources/shortcut.js"></script>
<script>

	var proxy = document.getElementById("proxy");
	proxy.addEventListener("click", function(){
		$.ajax({
			url: 'proxy.do', 
			dataType: 'xml',
			success: function(data){
				//city 태그 찾아오기 
				var cities = $(data).find('city');
				//jquery의 배열 순회 - data 태그를 찾아서 순회 
				//intdex는 순회하는 배열의 인덱스이고 item은 데이터 입니다. 
				$(data).find('data').each(function(index, itme){
						var output=''
						if(index%6 == 0){
							output += '<div><h2>'+ $(cities[index/6]).text()
							output +='<h2>'; 
						}	
						output +='<span>' + $(this).find('tmEf').text()
						output +='<span>' + $(this).find('wf').text()
						if(index%6 == 0){
							output += '</div>'
						}
						//body 태그 안에 기존 내용과 함께 출력 
						$('body').html($('body').html()+output)
					
					})
				}
		})
	});
	
	//push 
	
	document.getElementById("push").addEventListener("click",function(){
		//웹 푸시 객체 만들기
		var eventsrc = new EventSource("push.do");
		//메시지가 왔을 때 호출될 함수를 등록 
		eventsrc.addEventListener("message", function(result){
			document.getElementById("disp").innerHTML = result.data;
		})
	})
	
	//web socket 
	
	var websocket = new WebSocket("ws://localhost:8080/0911etc/websocket");
	
	//에러 발생한 경우 
	websocket.onerror =function(event){
		onError(event);
	}
	//처음 연결한 경우 
	websocket.onopen =function(event){
		onOpen(event);
	}
	//메시지가 온 경우 
	websocket.onmessage = function(event){
		onMessage(event);
	}
	
	function onError(event){
		alert(event.data);
	}
	function onOpen(event){
		document.getElementById("print").value = "연결되었습니다."
	}
	function onMessage(event){
		var print = document.getElementById("print");
		print.value = event.data + "\n" +print.value ; 
	}
	 shortcut.add("Enter",
	          function() {
	      		websocket.send(document.getElementById("nick").value + ":"+ document.getElementById("message").value)
	    		document.getElementById("message").value = null;
	    	});
	
	 document.getElementById("send").addEventListener("click", function(){
   		websocket.send(document.getElementById("nick").value + ":"+ document.getElementById("message").value)
 		document.getElementById("message").value = null;
 	})
	
</script>
</html>
