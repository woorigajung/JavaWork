<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>        
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL Core3</title>
</head>

<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>

<body>
<h2>if</h2>
	<!-- 스크립트릿만 사용하는 경우 1 -->
	<% if(1 + 2 == 3){ %>
		1 + 2 = 3<br>
	<% } %>
	
	<!-- 스크립트릿만 사용하는 경우 2 -->
	<%
		if(1 + 2 == 3){
			out.println("1 + 2 = 3<br>");
		}
	%>
	
	<!-- JSTL 사용 -->
	<c:if test="${1 + 2 == 3 }"> <%-- EL식 사용 --%>
		1 + 2 = 3: EL식 사용 가능 <br>
	</c:if>
	
	<c:if test="true"> <%-- 항상 참 --%>
		true<br>
	</c:if>
	
	<c:if test="<%= 1 + 2 == 3 %>"> <%-- 표현식 사용 --%>
		1 + 2 = 3 : JSP 표현식 가능<br>
	</c:if>

	<c:if test="${1 + 2 != 3 }">
		1 + 2 != 3<br>
	</c:if>

<hr>
<%-- JSTL 에선 c:else 는 따로 없다!  대신 choose, when 을 조합하여 사용 --%>

<h2>choose, when, otherwise</h2>

	<!-- 스크립트릿만 사용하는 경우1 -->
	<%
		switch(10 % 2){
		case 0:
	%>
			짝수입니다<br>
	<%
			break;
		case 1:
	%>
			홀수입니다<br>
	<%
			break;
		default:
	%>
			이도 저도 아닙니다<br>
	<%
		} // end switch
	%>

	<!-- JSTL 사용하는 경우 -->
	<c:choose>
		<c:when test="${10 % 2 == 0 }">
			짝수입니다<br>
		</c:when>
		<c:when test="${10 % 2 == 1 }">
			홀수입니다<br>
		</c:when>
		<c:otherwise>
			이도 저도 아닙니다<br>
		</c:otherwise>
	</c:choose>

<hr>
<h2>forEach</h2>

	<!-- 스크립트릿만 사용하는 경우 -->
	<%
		for(int i = 0; i <= 30; i += 3){
	%>
			<span><%= i %></span>
	<%
		}
	%>
	
	<br>
	
	<!-- JSTL을 사용하는 경우 -->
	<c:forEach var="i" begin="0" end="30" step="3">
		<span>${i }</span>
	</c:forEach>
	
	<!--  구구단 3단 
		3 * 1 = 3
		3 * 2 = 6
		..
		3 * 9 = 27
	 -->
	 
	 <ul>
	 <c:forEach var="i" begin="1" end="9">
		<li>3 * ${i} = ${3 * i }</li>
	</c:forEach>
	 </ul>

	<br>
	<c:set var="intArray" value="<%= new int[]{1, 2, 3, 4, 5} %>"/>

	<c:forEach var="element" items="${intArray }">
		${element },
	</c:forEach>
	<br>
	
	<!-- intArray 배열인덱스 2 ~ 4 번재 값 출력 -->
	<c:forEach var="element" items="${intArray }" begin="2" end="4">
		${element },
	</c:forEach>
	<br>
	
	<!-- intArray 배열 인덱스 2 ~ 4번째 loop 정보가 status 변수 에 담김 -->
	<c:forEach var="element" items="${intArray }" 
		begin="2" end="4" varStatus="status">
		${status.count } : intArray[${status.index }] = ${element } <br>
	</c:forEach>
	<br>
	
	<%-- 복수개의 배열/collection 도 다룰수 있다 --%>
	
	<%
		List<String> myList = new ArrayList<String>();
		myList.add("월");
		myList.add("화");
		myList.add("수");
	%>
	
	<c:set var="arr1" value='<%= new String[]{"SUN", "MON", "TUE"}%>'/>
	<c:set var="arr2" value='<%= myList %>'/>
	<ul>
	<c:forEach var="element" items="${arr1 }" varStatus="status">
		<li>${status.index} : ${element } - ${arr2[status.index] }</li>
	</c:forEach>
	</ul>
	<br>
	
	<%
		HashMap<String, Object> hMap = new HashMap<String, Object>();
		hMap.put("name", "장윤성");
		hMap.put("age", 26);
		hMap.put("today", new Date());  // 오늘날짜
	%>
	
	<c:set var="map1" value="<%= hMap %>"/>
	<table>
		<tr><th>key</th><th>value</th></tr>
		<c:forEach var="item" items="${map1 }">
			<tr>
				<td>${item.key }</td>
				<td>${item.value }</td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>















