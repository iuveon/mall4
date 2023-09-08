<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<h2>회원 정보</h2>
		<table>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="m_id" readonly value="<c:out value="${ info.m_id }"/>">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="m_name" readonly value="<c:out value="${ info.m_name }"/>">
				</td>
			</tr>
			<tr>
				<td>메일주소</td>
				<td>
					<input type="text" name="m_email1" readonly value="<c:out value="${ info.m_email1 }"/>">
					@
					<input type="text" name="m_email2" readonly value="<c:out value="${ info.m_email2 }"/>">
				</td>
			</tr>
			<tr>
				<td>연락처</td>
				<td>
					<input type="text" name="m_phone" readonly value="<c:out value="${ info.m_phone }"/>">
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<input type="text" name="m_birth" readonly value="<c:out value="${ info.m_birth }"/>">
				</td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>
					<input type="text" name="m_zipcode" readonly value="<c:out value="${ info.m_zipcode }"/>">
				</td>
			</tr>
			<tr>
				<td>도로명 주소</td>
				<td>
					<input type="text" name="m_address1" readonly value="<c:out value="${ info.m_address1 }"/>">
				</td>
			</tr>
			<tr>
				<td>지번 주소</td>
				<td>
					<input type="text" name="m_address2" readonly value="<c:out value="${ info.m_address2 }"/>">
				</td>
			</tr>
			<tr>
				<td>상세 주소</td>
				<td>
					<input type="text" name="m_restAddress" readonly value="<c:out value="${ info.m_restAddress }"/>">
				</td>
			</tr>
		</table>
	
	<button data-oper='update'>수정하기</button>
	<button data-oper='list'>목록보기</button>
	<form id='operForm' action="./update" method="post">
		<input type='hidden' id='m_id' name='m_id' value='<c:out value="${ info.m_id }"/>'>
	</form>
	<script type="text/javascript">
		$(document).ready(function() {
			var operForm = $("#operForm");
			
			$("button[data-oper='update']").on("click", function(e) {
				operForm.attr("action", "./update").submit();
			});
			
			$("button[data-oper='list']").on("click", function(e) {
				operForm.attr("action", "./list")
				operForm.submit();
			});
		});
	</script>
</body>
</html>