<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** web02 MVC **</title>
</head>
<body>

<h2>** web02 MVC 회원관리 **</h2>
<hr>

<c:if test="${not empty sessionScope.loginID}">
	${sessionScope.loginName}님 안녕하세요 <br>
</c:if>

<hr>
<img alt="mainImage" src="./images/a2.png" width="420" height="280">
<hr>
<!-- => 로그인 전/후 메뉴 구분, MyInfo 메뉴 추가 -->
<c:if test="${empty sessionScope.loginID}">
&nbsp;<a href="/web02/member/loginForm.jsp">LoginF</a>&nbsp;
&nbsp;<a href="/web02/member/joinForm.jsp">JoinF</a>&nbsp;
</c:if>
<c:if test="${not empty sessionScope.loginID}">
&nbsp;<a href="/web02/mdetail">MyInfo</a>&nbsp;
&nbsp;<a href="/web02/mdetail?jCode=U">내정보수정</a>&nbsp;
<!-- 내정보 수정 -> 서블릿(selectOne) -> 내정보 출력(수정가능한 form Tag에)
		 -> 즉, 출력 & 수정가능한 updateForm.jsp -->
&nbsp;<a href="/web02/logout">Logout</a>&nbsp;
&nbsp;<a href="/web02/mdelete">탈퇴</a>&nbsp;
</c:if>
<hr>
&nbsp;<a href="/web02/mlist">MList</a>&nbsp;

</body>
</html>