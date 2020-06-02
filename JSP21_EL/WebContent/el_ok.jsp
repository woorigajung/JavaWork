<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EL 내장객체</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String [] hobby = request.getParameterValues("hobby");
%>
아이디: <%= id %><br>
비밀번호 : <%= pw %> <br>
취미 : 
<% for(int i = 0; i < hobby.length; i++){ %>
	<%= hobby[i] %>
<% } %>
<hr>

아이디 : ${param.id }<br>
비밀번호 : ${param.pw }<br>
취미  : ${paramValues.hobby[0] }
	${paramValues.hobby[1] }
	${paramValues.hobby[2] }<br>
<hr>

아이디 : ${param["id"] }<br>
비밀번호 : ${param["pw"] }<br>
취미  : ${paramValues["hobby"][0] }
	${paramValues["hobby"][1] }
	${paramValues["hobby"][2] }<br>
<hr>

applicationScope : ${applicationScope.application_name }<br>
sesseionScope : ${sessionScope.session_name }<br>
pageScope : ${pageScope.page_name }<br>
requestScope : ${requestScope.request_name }<br>
<hr>

context 초기화 파라미터 <br>
${initParam.con_name }<br>
${initParam.con_id }<br>
${initParam.con_pw }<br>
<hr>

ContextPath<br>
<%= request.getContextPath() %><br>
${pageContext.request.contextPath }<br>

<a href="/JSP21_EL/el_form.jsp">입력폼</a><br>
<a href="${pageContext.request.contextPath }/el_form.jsp">입력폼</a><br>



<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>















