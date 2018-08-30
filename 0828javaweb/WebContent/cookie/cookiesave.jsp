<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% // 쿠키에 저장되는 데이터가 한글이면 UTF-8로 인코딩하기 위한 클래스를 import %>
<%@ page import = "java.net.*" %>

<%	
	//띄어쓰기 예외발생 IllegalArgumentException - illegal characters(comma, space, or semicolon)
	String data = "Java Web Programming";
	//utf-8로 인코딩 
	String value =URLEncoder.encode(data, "utf-8") ;
	
	//쿠키 생성 
	Cookie cookie = new Cookie("JSP", value );
	//브라우저 요청오면 response cookie 브라우저에 저장 
	response.addCookie(cookie);


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 사용</title>
</head>
<body>
	<a href="cookiereader.jsp">쿠키읽기</a>
</body>
</html>