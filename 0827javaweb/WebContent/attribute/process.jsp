<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//파라미터 읽기 
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//콘솔에 읽은 파라미터 출력
		System.out.println(id);
		System.out.println(pw);
		
		//전송할 attribute 저장 
		
		//request에 저장  
		request.setAttribute("data1", "request데이터");
		//session에 저장 
		session.setAttribute("data2", "session데이터");
		
		//결과 페이지로 이동
		
		//forwarding으로 결과 페이지 이동 - forwarding 될 때는 request 객체와 session 객체 모두 공유됩니다.
		/* RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		dispatcher.forward(request, response); */
		
		//redirecting으로 결과 페이지 이동 -redirect 될 때는 request 객체는 새로 만들어지고 session 객체만 공유됩니다.
		response.sendRedirect("result.jsp");
	%>

</body>
</html>