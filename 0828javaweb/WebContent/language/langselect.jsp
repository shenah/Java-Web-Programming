<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 이용한 언어선택</title>
</head>
<body>
	<%
	//쿠키 읽기 
	Cookie [] cookies = request.getCookies();
	//쿠키 값 저장할 변수 
	String lang = "kor"; 
	if(cookies != null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("lang")){
				lang = cookie.getValue();
			}
		}
		
	}
	if(lang.equals("en")){
		out.println("<h3>English</h3>");
	}else if(lang.equals("ch")){
		out.println("<h3>简体中文</h3>");
	}else{
		out.println("<h3>한국어</h3>");
	}
	%>
	<form action ="langsave.jsp">
		<h3>언어선택</h3>
		<input type = "radio" value="en" id="english" name="lang"/>영어
		<input type = "radio" value="ko" id="korean" name="lang" checked="checked"/>한국어 
		<input type = "radio" value="ch" id="chinese" name="lang"/>중국어 
		<input type = "submit" value="선택완료"/>
	
	</form>
	<script>
		<%if(lang.equals("en")){
			out.println("document.getElementById('english').checked=true");
		}
		if(lang.equals("ch")){
			out.println("document.getElementById('chinese').checked=true");
		}
		%>
		
	
	</script>
	
</body>
</html>