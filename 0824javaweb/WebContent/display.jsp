<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	List <String> list = new ArrayList<>(); 
	list.add("블랙핑크");
	list.add("트와이스");
	list.add("방탄소년단");
	for(String str : list){
		out.print("<p>" + str + "</p>");
	}
	%>
</body>
</html>