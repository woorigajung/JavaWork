<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL Core 2</title>
</head>
<body>

<h2>set, remove, out</h2>
<c:set var="name" value="장윤성"/>
이름: <c:out value='jang'/><br>
이름: <c:out value='${name }'/><br>  <%-- JSTL 변수는 EL 에서 사용 가능 --%>
${name }<br>

<c:remove var="name"/>
이름: <c:out value='${name }'/><br>

<hr>

<%
	int age = 10;
%>
나이: ${age }<br> <%-- Java → EL (X) --%>
<c:set var="age" value="<%= age %>"/>
나이: ${age }<br> <%-- Java → JSTL → EL (○) --%>

<hr>
<h2>catch</h2>

<c:catch var="error">
<!-- 이 안에서 예외 발생하면 예외객체를 error 변수에 담는다 -->
	<%= 2 / 0 %>
</c:catch>
<br>
<c:out value="${error }"/>

<br>

<c:catch var="ex">
name parameter 값 = <%= request.getParameter("name")%><br>

<% if(request.getParameter("name").equals("test")){ // 예외 발생 


		//request 받은 값은 다 param 객체에 담긴다%> 
	${param.name } 은 test 입니다.
	
<% } %>

</c:catch>

<c:if test="${ex != null }">
	예외발생<br>
	${ex }<br>
</c:if>










<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>















