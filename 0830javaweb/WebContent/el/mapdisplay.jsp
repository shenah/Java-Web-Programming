<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>map 출력</title>
</head>
<body>
	${data["name"] } <br/>
	${data.age }<!-- VO에서 .age는 변수를 부른것이 아니라 getAge()를 부른 것이다.  -->
</body>
</html>