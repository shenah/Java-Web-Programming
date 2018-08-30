<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//forwarding 
	
	 //데이터 저장 
	/* request.setAttribute("id", "tiktok");
	request.setAttribute("score", 80);
	//결과 페이지 이동 
	RequestDispatcher rd = request.getRequestDispatcher("attributedisplay.jsp");
	rd.forward(request, response); */ 
	
	//redirecting 
	session.setAttribute("nick", "shenah");
	session.setAttribute("score", 0);
	
	response.sendRedirect("attributedisplay.jsp");
%>
