<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 후기 게시판</title>
</head>
<body>
	<div><button id="regBtn" type="button">상품 후기 등록</button></div>

	<table border="1">
		<tr>
			<th>#번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>수정일</th>
		</tr>
	
	<c:forEach items="${list}" var="review">
		<tr>
			<td><c:out value="${review.b_num}"></c:out></td>
			<td><a href='/review/get?b_num=<c:out value="${review.b_num}"/>'><c:out value="${review.b_title}"/></a></td>
			<td><c:out value="${review.b_writer}"></c:out></td>
			<td><fmt:formatDate type="both" dateStyle="long" value="${review.b_regdate}"/></td>
			<td><fmt:formatDate type="both" dateStyle="long" value="${review.b_editdate}"/></td>
		</tr>
	</c:forEach>
	
	</table>
	
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>	

<script>
// 상품 후기 등록 버튼 클릭 시 register 페이지로 이동
$(document).ready(function() {
	$("#regBtn").on("click", function(){
		self.location = "/review/register";
	});
});
</script>

</body>
</html>