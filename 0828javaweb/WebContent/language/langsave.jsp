<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터를 읽어서 쿠키에 저장하고 원래 위치 돌아가기</title>
</head>
<body>

	<%
		// name 파라미터 읽기 
		String name = request.getParameter("lang");
	
		// 파라미터를 쿠키에 저장 
		Cookie cookie = new Cookie("lang", name); 
		response.addCookie(cookie);
		
		// 원래위치 되돌아가기
		response.sendRedirect("langselect.jsp");
	%>
</body>
</html>