<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지 </title>
</head>
<body>
	에러타입:<%=exception.getClass().getName() %><br/>
	에러메세지: <%=exception.getMessage() %>
</body>
</html>