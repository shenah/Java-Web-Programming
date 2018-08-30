<%@page import="vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>map 생성</title>
</head>
<body>
<%
	//map 생성 및 데이터 저장 
	Map <String, Object> map = new HashMap<>();
	map.put("name", "제니");
	map.put("age", 22);
	
	//request.setAttribute("data", map);
	
	//VO 객체 생성 및 데이터 저장 
	Person person = new Person();
	person.setName("리사");
	person.setAge(21);
	
	request.setAttribute("data", person);
	
	
	//forwarding 
	RequestDispatcher dispatcher = request.getRequestDispatcher("mapdisplay.jsp");
	dispatcher.forward(request, response);

%>
</body>
</html>