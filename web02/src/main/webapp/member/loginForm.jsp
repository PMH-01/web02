<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** MVC2 LoginForm **</title>
</head>
<body>
<h2>** MVC2 LoginForm **</h2>
<form action="/web02/login" method="post">
<table>
	<tr height="40">
		<td bgcolor="Khaki"><label for="id">ID</label></td>
		<td><input type="text" id="id" name="id"></td>
	</tr>
	<tr height="40">
		<td bgcolor="Khaki"><label for="password">Password</label></td>
		<td><input type="password" id="password" name="password"></td>
	</tr>
	<tr height="40">
		<td bgcolor="Khaki"><label for="password">Password</label></td>
		<td>
			<input type="submit" value="로그인">&nbsp;&nbsp;
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</form>
<hr>
<c:if test="${not empty requestScope.message}">
=> ${requestScope.message}
</c:if>
<hr>
	&nbsp;<a href="/web02/">Home</a>&nbsp;
	&nbsp;<a href="javascript:history.go(-1)">이전으로</a>

</body>
</html>