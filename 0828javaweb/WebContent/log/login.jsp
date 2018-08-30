<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
<style>
	body{background-color:black;}
	h1{color:#cccccc;}
	div{color:white}
	input{
		width: 100%; /* 원하는 너비 설정 */ 
		height: 100; /* 높이값 초기화 */ 
		line-height : 200%; /* line-height 초기화 */ 
		padding: .8em .5em; /* 원하는 여백 설정, 상하단 여백으로 높이를 조절 */ 
		font-family: inherit; /* 폰트 상속 */ 
		border: 1px solid #999; 
		border-radius: 0; /* iSO 둥근모서리 제거 */ 
		outline-style: none; /* 포커스시 발생하는 효과 제거를 원한다면 */ 
		-webkit-appearance: none; /* 브라우저별 기본 스타일링 제거 */ 
		-moz-appearance: none; 
		appearance: none;
		
	}
	input[type="submit"]{background-color:#99cc33; font-color:white;}
	
</style>
</head>
<body>

	<form action="loginprocess.jsp" method ="post">
		<table align="center" cellspacing="10">
			<h1 align="center">로그인</h1>
			<tr>
				<td align="center"><input type = "text" name="id" placeholder="아이디"/></td>
			</tr>
			<tr>
				<td align="center"><input type = "password" name="pw" placeholder="비밀번호"/></td>
			</tr>
<%
	if(session.getAttribute("msg") != null){
		out.println("<tr><td align='center'><div>"+ session.getAttribute("msg") + "</div></td></tr>");
	}

%>
			<tr>
				<td width="400" align="center">
				<input type = "submit" id="submit" value="로그인"/>
				<input type = "button" id="btn" value="메인으로"/>
				</td>
			</tr>
		</table>
		
	
	
	</form>
</body>
<script>
	var btn = document.getElementById("btn");
	btn.addEventListener("click", function(e){
		location.href='main.jsp';
	})

</script>
</html>