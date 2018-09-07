<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery 연습</title>
<style>
	a{ text-decoration: "none"}

</style>
</head>
<body>
	프로젝트 이름까지의 경로:
	${pageContext.request.contextPath}<br/>
	
	<input type="button" value="확인" id="btn"/><br/>
	<a href="logout">로그아웃</a><br/>
	
	<nav>
		<ul>
			<li><a href="login.do">로그인</a></li>
			<li><a href="register.do">회원가입</a></li>
		</ul>
	</nav>
	
	
</body>
<script src="${pageContext.request.contextPath}/resourses/js/jquery.js"></script>
<script>
	//스크립트에 $로 시작하면 jquery를 사용한 것 
	//문서의 내용을 전부 읽자 마자 
	$(function(){
		//alert("jquery를 사용합니다.")
	});
	
	$('#btn').bind('click',function(){
		console.log("로그를 출력합니다.")
	});
	
	$(window).bind('beforeunload', function(){
		$.ajax({
			url:"logout"
		})
	});
	
	

</script>
</html>