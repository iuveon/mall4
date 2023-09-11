<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>

<div class="untree_co-section">
	<div class="container">
		<div class="block">
			<div class="row justify-content-center">
				<div class="col-md-8 col-lg-8 pb-4">
					<form action="/member/join" method="post">
						<h2>회원가입</h2>
						<div class="row">

							<div class="form-group">
								<label class="text-black">아이디</label>
								<input type="text" class="form-control" name="m_id">
							</div>
							<div class="form-group">
								<label class="text-black">이름</label>
								<input type="text" class="form-control" name="m_name">
							</div>
							<div class="form-group">
								<label class="text-black">메일주소</label>
								<input type="text" class="form-control" name="m_email">
							</div>
							<div class="form-group">
								<label class="text-black">연락처</label>
								<input type="text" class="form-control" name="m_phone">
							</div>
							<div class="form-group">
								<label class="text-black">생년월일</label>
								<input type="text" class="form-control" name="m_birth">
							</div>
							<div class="form-group">
								<label class="text-black">우편번호</label>
								<input type="text" class="form-control" name="m_zipcode">
							</div>
							<div class="form-group">
								<label class="text-black">도로명주소</label>
								<input type="text" class="form-control" name="m_address1">
							</div>
							<div class="form-group">
								<label class="text-black">지번주소</label>
								<input type="text" class="form-control" name="m_address2">
							</div>
							<div class="form-group">
								<label class="text-black">상세 주소</label>
								<input type="text" class="form-control" name="m_restAddress">
							</div>
							
						<button type="submit" class="btn btn-primary-hover-outline">작성하기</button>
						<button type="reset" class="btn btn-primary-hover-outline">다시하기</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(funcion(){
		var result = '<c:out value="${result}"/>';
	});
</script>

</body>
</html>