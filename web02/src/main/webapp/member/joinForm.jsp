<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** MVC2 Member Join **</title>
</head>
<body>
<h2>** MVC2 Member Join **</h2>
<form action="/web02/mjoin" method="post">
	<table>
		<tr height="40"><th bgcolor="skyblue"><lable for="id">I D</lable></th>
			<td><input type="text" name="id" id="id" placeholder="영문+숫자 4~10글자로 작성해주세요" size="20"></td>
		</tr>
		<tr height="40"><th bgcolor="skyblue"><lable for="password">Password</lable></th>
			<td><input type="password" name="password" id="password" placeholder="영문+숫자 4~10글자로 작성해주세요" size="20"></td>
		</tr>
		<tr height="40"><th bgcolor="skyblue"><lable for="name">Name</lable></th>
			<td><input type="text" name="name" id="name" size="20"></td>
		</tr>
		<tr height="40"><th bgcolor="skyblue">Age</th>
			<td><input type="text" name="age" id="age" size="20"></td>
		</tr>
		<tr height="40"><th bgcolor="skyblue">Jno</th>
			<td>
				<select name="jno" id="jno">
					<option value="1">1조:nomard</option>
					<option value="2">2조:2조</option>
					<option value="3">3조:happyWinter</option>
					<option value="7">7조:7면조</option>
				</select>
			</td>
		</tr>
		<tr height="40"><th bgcolor="skyblue">Info</th>
			<td><input type="text" name="info" id="info" size="20"></td>
		</tr>
		<tr height="40"><th bgcolor="skyblue">Point</th>
			<td><input type="text" name="point" id="point" size="20"></td>
		</tr>
		<tr height="40"><th bgcolor="skyblue">Birthday</th>
			<td><input type="date" name="birthday" id="birthday"></td>
		</tr>
		<tr height="40"><th bgcolor="skyblue">추천인</th>
			<td><input type="text" name="age" id="age" size="20"></td>
		</tr>
		<tr height="40"><td></td>
			<td><input type="submit" value="회원가입">&nbsp;&nbsp;</td>
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