<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<%-- 위에는 꼭해야됨
	안하면 웹사이트를 표시할 수 없습니다 뜸 --%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>에러 안내</title>
</head>
<body>
에러가 발생했습니다... <br>
예외 타입은 : <%= exception.getClass().getName() %><br>
예외 메세지는 : <%= exception.getMessage() %>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>















