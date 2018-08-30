<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<%
	List <Map<String, Object>> list = new ArrayList<>();
	
	Map <String, Object> map = new HashMap<>();
	map.put("num", 2);
	map.put("title", "가입사인");
	map.put("nickname", "tiktok");
	map.put("regdate", "2018-08-30");
	map.put("readcnt", 34);
	
	list.add(map);
	
	map = new HashMap<>();
	map.put("num", 1);
	map.put("title", "테스트");
	map.put("nickname", "관리자");
	map.put("regdate", "2018-07-30");
	map.put("readcnt", 36);
	
	list.add(map);
	
	request.setAttribute("list", list);
	RequestDispatcher rd = request.getRequestDispatcher("boardview.jsp");
	rd.forward(request, response);

%>

