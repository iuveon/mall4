<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>새 게시글 등록</div>
	
	<div>
		<form action="/review/register" method="post">
			<div><label>제목</label><input name="b_title"></div>
			<div><label>내용</label><textarea name="b_content" rows="3"></textarea></div>
			<div><label>작성자</label><input name="b_writer"></div>
			<button type="submit">작성 완료</button>
			<button type="reset">되돌리기</button>
			<button type="button">작성 취소</button>	
		</form>
	</div>
</body>
</html>