<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력</title>
</head>
<body>
	<form action="process.jsp" id ="myform" method="post">
	    아이디: <input type="text" name="id" required="required"/><br/>
		비밀번호: <input type="password" name="pw" required= "required"/><br/>
		<input type="submit" value="로그인"/><br/>
		
	</form>

</body>
</html>