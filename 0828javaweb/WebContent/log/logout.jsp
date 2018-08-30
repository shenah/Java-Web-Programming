<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>

</head>
<body>
<%
	//세션을 초기화 - id가 없으므로 로그아웃 효과 발생 
	session.invalidate();
%>
	<p>로그아웃 하셨습니다.</p>
	<p>5초 후에 메인 페이지로 이동합니다.</p>
</body>
<script>
	//5초 후에 동작하는 타이머
	setTimeout(function(){
		location.href='main.jsp';
	}, 5000);
</script>
</html>