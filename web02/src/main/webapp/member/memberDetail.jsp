<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** MVC2 Member Detail **</title>
</head>
<body>
<h2>** MVC2 Member Detail **</h2>
<table>
<c:if test="${not empty requestScope.mdto}">
	<tr height="40"><th bgcolor="skyblue">I D</th>
		<td>${requestScope.mdto.id}</td>
	</tr>
	<tr height="40"><th bgcolor="skyblue">Password</th>
		<td>${requestScope.mdto.password}</td>
	</tr>
	<tr height="40"><th bgcolor="skyblue">Name</th>
		<td>${requestScope.mdto.name}</td>
	</tr>
	<tr height="40"><th bgcolor="skyblue">Age</th>
		<td>${requestScope.mdto.age}</td>
	</tr>
	<tr height="40"><th bgcolor="skyblue">Jno</th>
		<td>${requestScope.mdto.jno}</td>
	</tr>
	<tr height="40"><th bgcolor="skyblue">Info</th>
		<td>${requestScope.mdto.info}</td>
	</tr>
	<tr height="40"><th bgcolor="skyblue">Point</th>
		<td>${requestScope.mdto.point}</td>
	</tr>
	<tr height="40"><th bgcolor="skyblue">Birthday</th>
		<td>${requestScope.mdto.birthday}</td>
	</tr>
	<tr height="40"><th bgcolor="skyblue">추천인</th>
		<td>${requestScope.mdto.rid}</td>
	</tr>
</c:if>
<c:if test="${empty requestScope.mdto}">
	<tr><td colspan="2">~~ 출력할 자료가 없습니다. ~~</td></tr>
</c:if>
</table>
<hr>
&nbsp;<a href="/web02/">Home</a>&nbsp;
&nbsp;<a href="javascript:history.go(-1)" >이전으로</a>&nbsp;	
</body>
</html>