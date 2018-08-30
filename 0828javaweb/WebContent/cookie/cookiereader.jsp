<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.net.*" %>
<%
	//모든 쿠키 가져오기 
	Cookie [] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키읽기</title>
</head>
<body>
    
	<%
		if(cookies != null && cookies.length > 0 ){
			for(Cookie cookie : cookies){
				String data = cookie.getValue();
				String value = URLDecoder.decode(data, "utf-8"); 
				out.println(cookie.getName() + ":" + value + "<br/>");
			}
		}
		
	%>
</body>
</html>