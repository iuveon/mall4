<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트 메인</title>
</head>
<body>

<form action="/login" method="post">
    <label for="id">아이디:</label>
    <input type="text" id="id" name="id" required><br><br>
    
    <label for="password">비밀번호:</label>
    <input type="password" id="password" name="password" required><br><br>
    
    <input type="submit" value="로그인">
</form>

</body>
</html>