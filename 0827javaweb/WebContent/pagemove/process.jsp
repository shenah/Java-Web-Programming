<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처리 파일</title>
	<%  
		//post로 전송한 파라미터는 읽기 전에 인코딩 처리를 해줘야 한다.
	    request.setCharacterEncoding("utf-8");
	
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		//ajax가 요청한 파라미터 확인하기  
		System.out.println(email);
		

	%>
</head>
<body>
	<h3>처리 파일입니다.</h3>
	<p>닉네임:<%=nickname %></p>
	<p>이메일: <%=email %></p>
	<p>비밀번호: <%=pw %></p>
	
	
</body>
</html>