<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
<%
	//세션에 저장된 데이터를 가져오기 - 없으면 null 
	String id = (String)session.getAttribute("id");
	String nickname = (String)session.getAttribute("nickname");
	
	if(id == null){
		out.println("<a href= 'login.jsp'>로그인</a></br>");
	}else{
		out.println("<p>" + nickname + "님 환영합니다!" + "</p>");
		out.println("<a href='logout.jsp'>로그아웃</a><br/>");
	}

%>
	 
	
</body>
</html>