<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피보나치 수열</title>
</head>
<body>
<%
	//20번째 피보나치 수열구하기 
	int n1 = 1;
	int n2 = 1; 
	int fib = 1;
	
	int idx = 3;
	while(idx<=20){
		fib = n1 + n2;
		n1 = n2; 
		n2 = fib; 
		idx = idx + 1; 
	}
%>
20번째 피보나치 수열은 <%=fib %>입니다. 
</body>
</html>