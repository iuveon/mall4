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
	<form role="form" action="./update" method="post">
		<div class="form-group">
			<label>m_id</label>
			<input class="form-control" name='m_id' value='<c:out value="${ info.m_id }"/>' readonly>
		</div>
		<div class="form-group">
			<label>m_name</label>
			<input class="form-control" name='m_name' value='<c:out value="${ info.m_name }"/>' readonly>
		</div>
		<div class="form-group">
			<label>m_email</label>
			<input class="form-control" name='m_email' value='<c:out value="${ info.m_email1 }"/>@<c:out value="${ info.m_email2 }"/>' readonly>
		</div>
		<div class="form-group">
			<label>m_phone</label>
			<input class="form-control" name='m_phone' value='<c:out value="${ info.m_phone }"/>' readonly>
		</div>
		<div class="form-group">
			<label>m_birth</label>
			<input class="form-control" name='m_birth' value='<c:out value="${ info.m_birth }"/>'>
		</div>
		<div class="form-group">
			<label>m_zipcode</label>
			<input class="form-control" name='m_id' value='<c:out value="${ info.m_zipcode }"/>'>
		</div>
		<div class="form-group">
			<label>m_address1</label>
			<input class="form-control" name='m_address1' value='<c:out value="${ info.m_address1 }"/>'>
		</div>
		<div class="form-group">
			<label>m_address2</label>
			<input class="form-control" name='m_address2' value='<c:out value="${ info.m_address2 }"/>'>
		</div>
		<div class="form-group">
			<label>m_restAddress</label>
			<input class="form-control" name='m_restAddress' value='<c:out value="${ info.m_restAddress }"/>'>
		</div>
		
		<button type="submit" data-oper='update' class="btn btn-default">수정하기</button>
		<button type="submit" data-oper='delete' class="btn btn-default">탈퇴하기</button>
		<button type="submit" data-oper='list' class="btn btn-default">회원목록</button>
	</form>
	
	<script type="text/javascript">
		$(document).ready(function() {
			var formObj = $("form");
			
			$('button').on("click", function(e) {
				e.preventDefault();
				
				var operation = $(this).data("oper");
				
				console.log(operation);
				
				if(operation === 'delete') {
					formObj.attr("action", "./delete");
				} else if(operation === 'list') {
					// move to list
					self.location="./list";
					return;
				}
				formObj.submit();
			});
		});
	</script>
</body>
</html>