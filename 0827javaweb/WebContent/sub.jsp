<!-- 사용하는 프로그래밍 언어를 설정하고 출력하는 파일의 종류, 현재 페이지 코딩의 인코딩 방식을 설정
	 출력하는 jsp 파일의 경우 이태그를 삭제하면 안됩니다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<p>다른 페이지에 포함될 공통된 내용을 포함한 파일</p>
<%@ page import = "java.net.*" %>
<% String msg = request.getParameter("data");
	msg = URLDecoder.decode(msg, "utf-8");
%>
<p>파라미터 출력:<%=msg%></p>