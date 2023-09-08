<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
	<h2>회원 리스트</h2>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>번호</th>
		</tr>
		<c:forEach items="${ list }" var="member">
			<tr>
				<td>
					<a href="./info?m_id=<c:out value="${ member.m_id }"/>"><c:out value="${ member.m_id }"/></a>
				</td>
				<td><c:out value="${ member.m_name }"/></td>
				<td><c:out value="${ member.m_phone }"/></td>
			</tr>
		</c:forEach>
	</table>
</body>

</html>