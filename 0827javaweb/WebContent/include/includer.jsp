<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소스 코드 포함하기</title>
</head>
<body>
	<%
		int num = 100;
	
	%>
	<%@ include file="includee.jspf" %>
	<div><%=msg %></div>
</body>
</html>