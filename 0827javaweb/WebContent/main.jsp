<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포함하는 페이지</title>
</head>
<body>
	<p>jsp include는 다른 페이지의 수행결과를 포함하는 페이지입니다.</p>
	<%@ page import = "java.net.*" %>
	<%
		String m = "데이터";
		String msg = URLEncoder.encode(m, "utf-8");
	%> 
	<jsp:include page="sub.jsp" flush="false">
		<jsp:param name="data" value = "<%=msg%>"/>
	</jsp:include>
	
</body>
</html>