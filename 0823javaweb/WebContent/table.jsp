<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> 
<%@ page import ="java.util.*" %>
<%
	//테이블 형식의 데이터 만들기 
	List<Map<String, Object>> list = new ArrayList<>();
	Map<String, Object> map = new HashMap<>();
	map.put("name", "제니");
	map.put("age", 22);
	list.add(map);
	
	map = new HashMap();
	map.put("name", "로제");
	map.put("age", 21);
	list.add(map);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>table</title>
</head>
<body>
	<table border = "1" align="center" width="300">
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>		
		<% for(Map m : list){ %>
			<tr>
				<td><%=m.get("name") %></td>
				<td><%=m.get("age") %></td>
			</tr>
		<%}%>

	</table>
</body>
</html>