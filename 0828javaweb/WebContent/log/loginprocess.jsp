<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
<%
	//post 방식으로 전송된 파라미터를 인코딩 처리 
	request.setCharacterEncoding("utf-8");
	//파라미터 읽어오기 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if(id.equals("system") && pw.equals("1234")){
		//로그인 정보를 세션에 저장 
		session.setAttribute("id", id);
		session.setAttribute("nickname", "관리자");
		
		//메인으로 리다이렉트 
		response.sendRedirect("main.jsp");
		
	}else{
		//로그인 실패 메세지 response
		session.setAttribute("msg", "아이디나 비밀번호가 틀렸습니다.");
		response.sendRedirect("login.jsp");
	}

%>
</body>
</html>