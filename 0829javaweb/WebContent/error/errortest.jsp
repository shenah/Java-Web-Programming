<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 발생 페이지</title>
</head>
<body>
	<%  //NullPointerException 발생 - 파라미터 없음  %>
	<%= request.getParameter("email").charAt(3) %>
</body>
</html>