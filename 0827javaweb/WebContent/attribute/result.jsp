<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>


</head>
<body>
	<h3>결과 페이지</h3>
	<p>request:<%=request.getAttribute("data1") %></p>
	<p>session:<%=session.getAttribute("data2") %></p>
</body>
</html>