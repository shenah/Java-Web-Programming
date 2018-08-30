<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 읽기</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		//없는 파라미터 이름을 사용하면 null 리턴 
		String address = request.getParameter("address");
		
	%>
	이름 : <%=name %><br/>
	나이 : <%=age %><br/>
	주소 : <%=address %>
	
	
</body>
</html>