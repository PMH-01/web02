<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** MVC2 Member UpdateForm **</title>
</head>
<body>
<h2>** MVC2 Member UpdateForm **</h2>
<form action="/web02/mupdate" method="post">
	<table>
		<!-- id,password는 제외하고 모두 수정 가능 
			=> id, password는 출력되지만, 수정은 불가능하고, submit시에 서버로 전송은 되어야함
				-> disabled: 서버로 전송안됨
				-> readonly: 서버로 전송됨(권장)-->
		<tr height="40"><th bgcolor="AliceBule"><lable for="id">I D</lable></th>
			<td><input type="text" name="id" id="id" value="${requestScope.mdto.id}" readonly size="20"></td>
		</tr>
		<tr height="40"><th bgcolor="AliceBule"><lable for="password">Password</lable></th>
			<td><input type="password" name="password" id="password" value="${requestScope.mdto.password}" readonly size="20"></td>
		</tr>
		<tr height="40"><th bgcolor="AliceBule"><lable for="name">Name</lable></th>
			<td><input type="text" name="name" id="name" value="${requestScope.mdto.name}" size="20"></td>
		</tr>
		<tr height="40"><th bgcolor="AliceBule">Age</th>
			<td><input type="text" name="age" id="age" value="${requestScope.mdto.age}" size="20"></td>
		</tr>
		<tr height="40"><th bgcolor="AliceBule">Jno</th>
			<td>
				<select name="jno" id="jno">
					<option value="1" ${mdto.jno==1 ? "selected" : ""}>1조:nomard</option>
					<option value="2" ${mdto.jno==2 ? "selected" : ""}>2조:2조</option>
					<option value="3" ${mdto.jno==3 ? "selected" : ""}>3조:happyWinter</option>
					<option value="7" ${mdto.jno==7 ? "selected" : ""}>7조:7면조</option>
				</select>
			</td>
		</tr>
		<tr height="40"><th bgcolor="AliceBule">Info</th>
			<td><input type="text" name="info" id="info" value="${requestScope.mdto.info}" size="20"></td>
		</tr>
		<tr height="40"><th bgcolor="AliceBule">Point</th>
			<td><input type="text" name="point" id="point" value="${requestScope.mdto.point}" size="20"></td>
		</tr>
		<tr height="40"><th bgcolor="AliceBule">Birthday</th>
			<td><input type="date" name="birthday" id="birthday" value="${requestScope.mdto.birthday}" size="20"></td>
		</tr>
		<tr height="40"><th bgcolor="AliceBule">추천인</th>
			<td><input type="text" name="rid" id="rid" value="${requestScope.mdto.rid}" size="20"></td>
		</tr>
		<tr height="40"><td></td>
			<td><input type="submit" value="수정">&nbsp;&nbsp;</td>
			<td><input type="reset" value="취소"></td>
		</tr>
	</table>
</form>
<br><hr>
<c:if test="${not empty requestScope.message}">
=> ${requestScope.message}
</c:if>
<hr>
&nbsp;<a href="/web02/">Home</a>&nbsp;
&nbsp;<a href="javascript:history.go(-1)" >이전으로</a>&nbsp;	
</body>
</html>