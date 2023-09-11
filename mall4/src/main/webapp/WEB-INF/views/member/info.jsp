<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="untree_co-section">
	<div class="container">
		<div class="block">
			<div class="row justify-content-center">
				<div class="col-md-8 col-lg-8 pb-4">
					<h2>회원 정보</h2>
					<div class="row">
						<div class="form-group">
							<label class="text-black">아이디</label>
							<input type="text" class="form-control" name="m_id" readonly="readonly"
								value='<c:out value="${member.m_id}"/>'>
						</div>
						<div class="form-group">
							<label class="text-black">이름</label>
							<input type="text" class="form-control" name="m_name" readonly="readonly"
								value='<c:out value="${member.m_name}"/>'>
						</div>
						<div class="form-group">
							<label class="text-black">메일주소</label>
							<input type="text" class="form-control" name="m_email" readonly="readonly"
								value='<c:out value="${member.m_email1}"/>@<c:out value="${member.m_email2}"/>'>
						</div>
						<div class="form-group">
							<label class="text-black">연락처</label>
							<input type="text" class="form-control" name="m_phone" readonly="readonly"
								value='<c:out value="${member.m_phone}"/>'>
						</div>
						<div class="form-group">
							<label class="text-black">생년월일</label>
							<input type="text" class="form-control" name="m_birth" readonly="readonly"
								value='<c:out value="${member.m_birth}"/>'>
						</div>
						<div class="form-group">
							<label class="text-black">우편번호</label>
							<input type="text" class="form-control" name="m_zipcode" readonly="readonly"
								value='<c:out value="${member.m_zipcode}"/>'>
						</div>
						<div class="form-group">
							<label class="text-black">도로명주소</label>
							<input type="text" class="form-control" name="m_address1" readonly="readonly"
								value='<c:out value="${member.m_address1}"/>'>
						</div>
						<div class="form-group">
							<label class="text-black">지번주소</label>
							<input type="text" class="form-control" name="m_address2" readonly="readonly"
								value='<c:out value="${member.m_address2}"/>'>
						</div>
						<div class="form-group">
							<label class="text-black">상세 주소</label>
							<input type="text" class="form-control" name="m_restAddress" readonly="readonly"
								value='<c:out value="${member.m_restAddress}"/>'>
						</div>

					<button data-oper="update"
						onclick="location.href='/member/update?m_id=<c:out value="${member.m_id}"/>'"
						class="btn btn-primary-hover-outline">수정하기</button>
					<button data-oper="list" onclick="location.href='/member/list'"
						class="btn btn-primary-hover-outline">목록보기</button>
					<form id="operForm" action="/member/update" method="get">
						<input type="hidden" id="m_id" name="m_id"
							value="<c:out value='${member.m_id}'/>">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		var operForm = $("#operForm");

		$("button[data-oper='update']").on("click", function(e) {

			operForm.attr("action","/member/update").submit();

		});

		$("button[data-oper='list']").on("click", function(e) {

			operForm.find("#m_id").remove();
			operForm.attr("action","/member/list")
			operForm.submit();

		});
	});
</script>

</body>
</html>