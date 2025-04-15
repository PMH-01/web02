<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** MVC2 Student List **</title>
</head>
<body>
<h2>** MVC2 Student List **</h2>

<table border=1 style="width:100%">
<tr bgcolor="pink">
	<th>ID</th><th>Password</th><th>Name</th><th>Age</th><th>Jno</th>
	<th>Info</th><th>Point</th><th>Birthday</th><th>추천인ID</th>
</tr>

<c:if test="${not empty requestScope.mlist}">
	<c:forEach var="m" items="${requestScope.mlist}">
		<tr>
			<td>${m.id}</td><td>${m.password}</td><td>${m.name}</td><td>${m.age}</td><td>${m.jno}</td>
			<td>${m.info}</td><td>${m.point}</td><td>${m.birthday}</td><td>${m.rid}</td>
		</tr>
	</c:forEach>
</c:if>
<c:if test="${empty requestScope.mlist}">
	<tr>
		<td colspan="9">출력할 자료가 없습니다</td>
	</tr>
</c:if>
</table>
<hr>
	&nbsp;<a href="/web02/">Home</a>&nbsp;
	&nbsp;<a href="javascript:history.go(-1)">이전으로</a>
</body>
</html>