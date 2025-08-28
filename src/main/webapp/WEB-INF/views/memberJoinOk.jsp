<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
</head>
<body>
	<h2>회원가입 완료</h2>
	<hr>
	<h3>아이디 : ${memberDto.id}</h3>
	<h3>이 름 : ${memberDto.name}</h3>
	<h3>이메일 : ${memberDto.email}</h3>
</body>
</html>