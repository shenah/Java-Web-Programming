<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 출력</title>
</head>
<body>

	파라미터: ${param.query }<br/>
	쿠키(tostring): ${cookie.sessionid}<br/>
	쿠키값: ${cookie.sessionid.value }<br/>
	초기화 파라미터: ${initParam.user}<br/> 
	<%=application.getInitParameter("user") %>
</body>
</html>