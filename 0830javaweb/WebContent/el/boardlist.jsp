<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록 보기</title>
</head>
<body>
	<table border="1" align="center" >
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td align="center">${board.num }</td>
			<td align="center"><a href="boarddetail.jsp?num=${board.num}">${board.title }</a></td>
			<td align="center">${board.nickname }</td>
			<td align="center">${board.regdate }</td>
			<td align="center">${board.readcnt }</td>
		
	</table>
</body>
</html>