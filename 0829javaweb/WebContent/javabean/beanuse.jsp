<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<<jsp:useBean id="member" class="vo.Member" scope="request"></jsp:useBean>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javabean 사용</title>
</head>
<body>
<%
	out.println("<p>" + member+ "</p>");

%>
</body>
</html>