<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.WriteDTO" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EL request</title>
</head>
<body>
<%
	pageContext.setAttribute("myage", "흥~!");
	request.setAttribute("myage", 30);
	request.setAttribute("mydto", new WriteDTO(100, "제목", "내용", "작성자", 3));
%>

${myage }<br>
${requestScope.myage }<br>

${mydto }<br>  <%-- toString() 값 --%>
${mydto.uid }<br> 
<%= ((WriteDTO)request.getAttribute("mydto")).getUid() %><br>
${mydto.subject }<br>
${mydto.content }<br>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>















