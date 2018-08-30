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
		//post 인코딩 처리 - 반드시 파라미터 읽기 전에 수행.
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String description = request.getParameter("description");
	%>
	아이디: <%=id %><br/>
	비밀번호:<%=pw %><br/>
	이메일:<%=email %><br/>
	전화번호:<%=phone %><br/>
	자기소개:<%=description %><br/>
</body>
</html>