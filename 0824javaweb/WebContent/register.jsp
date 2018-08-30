<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<%@ page import="java.util.*, java.io.*" %>
	<%
		//문자열을 파일에 기록 
		//접속한 아이피 주소 가져오기 
		String ip = request.getRemoteAddr();
		Date date = new Date();
		
		Calendar cal = new GregorianCalendar();
		int year = cal.get(Calendar.YEAR);
		
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		String filename = year +"" + month +"" + day + ".txt";

		//기록할 파일 스트림 객체 만들기 
		//PrintWriter pw = new PrintWriter(new FileOutputStream("/Users/a503-03/Documents/log/log.txt", true));
		//날짜로 만든 로그 파일
		PrintWriter pw = new PrintWriter(new FileOutputStream("/Users/a503-03/Documents/log/" + filename, true));
		pw.println(ip + "-" + date + "\n");
		pw.flush();
		pw.close();
	
	%>

	<%
		//web.xml 파일에 설정한 초기화 파라미터 읽기
		String dbname = application.getInitParameter("dbname");
		//읽어온 내용 화면에 출력
		out.println("읽어온 파라미터:" + dbname + "<br/>");
	%>
	<form action="registerreceive.jsp" method="post">
	<table align="center" cellspacing="10">
		<h1 align="center">회원가입</h1>
		<tr>
			<td width="100" align="right">아이디:</td>
			<td width="200"><input type="text" name="id" size="20" placeholder="아이디"/></td>
		</tr>
		<tr>
			<td width="100" align="right">비밀번호:</td>
			<td width="200"><input type="password" name="pw" size="20"/></td>
		</tr>
		<tr>
			<td width="100" align="right">비밀번호확인:</td>
			<td width="200"><input type="password" size="20"/></td>
		</tr>
		<tr>
			<td width="100" align="right">이메일:</td>
			<td width="200"><input type="email" name="email"/></td>
		</tr>
		<tr>
			<td width="100" align="right">전화번호:</td>
			<td width="200"><input type="text" name="phone" size="11" maxlength="11"/></td>
		</tr>
		<tr>
			<td width="100" align="right">자기소개:</td>
			<td width="200"><textarea cols="40" rows= "10" name="description"></textarea></td>
		<tr>
			<td colspan="2" align="center">
			<input type ="submit" value="회원가입"/>
			<input type="reset" value="취소"/>
			</td>
		</tr>
	
	</table>
		
		
	
	
	</form>
</body>
</html>