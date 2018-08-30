<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<table rules="rows" width="700" align="center">
		<tr>
			<th width="50">글번호</th>
			<th width="300">글제목</th>
			<th width="80">작성자</th>
			<th width="80">작성일</th>
			<th width="50">조회수</th>

		</tr>

		<c:forEach var="map" items="${list}">
			<tr>
				<td align="center">${map.num }</td>
				<td>${map.title }</td>
				<td align="center">${map.nickname }</td>
				<td align="center">${map.regdate }</td>
				<td align="center">${map.readcnt }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>