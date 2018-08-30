<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>foreach로 데이터 읽기</title>
</head>
<body>
	<c:forEach var="str" items="${ar }"><li>${str }</li></c:forEach><br/>
	
	<c:forEach var="str" items="${list }"><li>${str }</li></c:forEach><br/>
	
	<c:forEach var="str" items="${map }"><li>${str }</li></c:forEach><br/>
	
	<c:forEach var="str" items="${fe }"><li>${str }</li></c:forEach><br/>
	
</body>
</html>