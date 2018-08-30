<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie cookie = new Cookie("sessionid", "EOGNg6VLIDI");
		response.addCookie(cookie);

	%>
	<a href="paramdisplay.jsp?query=rain">파라미터 출력</a>
</body>
</html>