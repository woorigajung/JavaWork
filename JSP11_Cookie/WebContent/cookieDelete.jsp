<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String cookieName = "num1";

	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookieName.equals(cookies[i].getName())) {
				cookies[i].setMaxAge(0); // expiry 를 0으로 하면
				response.addCookie(cookies[i]); // reponse 직후 곧바로 삭제됨.
				// 이렇게 하는 이유는 server는 쿠키를 만들어 넘기는 역활이지 저장하는 곳이 아님
				// 따라서 쿠키가 존재하는 시간을 0으로 설정해 client가 cookie 값을 받자마자 죽게 해야 됨

			}
		}
	}
%>
<script>
	alert("<%= cookieName %> 쿠키삭제")
	location.href = "cookieList.jsp"

</script>