<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일 보내기</title>
</head>
<body>
	<form action="sendmail.do" method="post" enctype="multipart/form=data">
		받는 사람: <input type="text" name="receiver" required="required"/><br/>
		제목:<input type="text" name="subject"/><br/>	
		첨부파일:<input type="file" name="file"/><br/>
		내용:<textarea rows="10" cols="30" name ="msg"></textarea>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>