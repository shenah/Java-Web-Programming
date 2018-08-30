<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%	
	//문자열 배열 만들기
	String [] ar = {"Java", "JavaScript", "Swift"};
	
	//문자열 list 만들기 
	List <String> list = new ArrayList<>();
	list.add("Oracle");
	list.add("MySQL"); 
	list.add("MongoDB");
	
	// Map 만들기
	Map<String, Object> map = new HashMap<>();
	map.put("language", "java");
	map.put("database", "oracle"); 
	
	//,로 구분된 문자열 만들기 
	String fe = "HTML,CSS,JavaScript";
	
	//결과 페이지에 전달할 데이터 저장   
	request.setAttribute("ar", ar);
	request.setAttribute("list", list);
	request.setAttribute("map", map); 
	request.setAttribute("fe", fe);
	
	//페이지 이동 
	RequestDispatcher rd = request.getRequestDispatcher("loop.jsp");
	rd.forward(request, response);


%>