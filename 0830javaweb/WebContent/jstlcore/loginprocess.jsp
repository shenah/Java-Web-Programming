<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션에 id를 저장 
	session.setAttribute("id", null);
	//결과 페이지로 리다이렉트 
	response.sendRedirect("loginresult.jsp");
%>