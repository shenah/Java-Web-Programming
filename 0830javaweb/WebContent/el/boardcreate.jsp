<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 데이터</title>
</head>
<body>
	<%@ page import="java.util.*" %>
	<% 
		Map <String, Object> map = new HashMap<>(); 
		map.put("num", 1);
		map.put("title","제목");
		map.put("nickname", "관리");
		map.put("regdate", "2018-08-30");
		map.put("readcnt", 232);
		
		request.setAttribute("board", map); 
		
		RequestDispatcher rd = request.getRequestDispatcher("boardlist.jsp");
		rd.forward(request, response);
	
	%>
</body>
</html>