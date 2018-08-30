<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import = "java.util.*" %>

<c:set var="date" value="<%=new Date() %>"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로케일 설정</title>
</head>
<body>
		<h3>대한민국</h3>
		<fmt:setLocale value="ko_kr"/>
		금액:<fmt:formatNumber value="1000000"  type="currency"/><br/>
		날짜:<fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="short"/>
		
		<h3>中国</h3>
		<fmt:setLocale value="zh_cn"/>
		金额:<fmt:formatNumber value="1000000"  type="currency"/><br/>
		日期:<fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="medium"/>
		
		<h3>USA</h3>
		<fmt:setLocale value="en_us"/>
		price:<fmt:formatNumber value="1000000"  type="currency"/><br/>
		date:<fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="long"/>
		
		<h3>日本</h3>
		<fmt:setLocale value="ja_jp"/>
		金額:<fmt:formatNumber value="1000000"  type="currency"/><br/>
		日付:<fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="full"/>
</body>
</html>