<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<jsp:useBean id="member" class="vo.Member" scope="request"></jsp:useBean>
<%
	member.setId("tiktok");
	member.setPw("1234");
	member.setName("관리자");
	member.setPhone("01074634874");
%>

<<jsp:forward page="beanuse.jsp"></jsp:forward>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javabean 생성</title>
</head>
<body>

</body>
</html>