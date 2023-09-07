<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>테스트 페이지</title>
</head>
<body>
테스트 페이지
<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>번호</th>
	</tr>
	<c:forEach items="${ list }" var="member">
		<tr>
			<td><c:out value="${ member.m_id }"/></td>
			<td><c:out value="${ member.m_name }"/></td>
			<td><c:out value="${ member.m_phone }"/></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="3">
			<form action="/member/update" method="post">
				<%= session.getAttribute("m_id") %>
				<input type="hidden" name="m_id" value="<%= session.getAttribute("m_id") %>">
				<button type="submit" name="update">수정</button>
				<button type="submit" name="delete">탈퇴</button>
			</form>
		</td>
	</tr>
</table>
</body>
</html>