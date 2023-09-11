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
					<form role="form" action="/member/update" method="post">
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
								<input type="text" class="form-control" name="m_email"
									value='<c:out value="${member.m_email1}"/>@<c:out value="${member.m_email2}"/>'>
							</div>
							<div class="form-group">
								<label class="text-black">연락처</label>
								<input type="text" class="form-control" name="m_phone"
									value='<c:out value="${member.m_phone}"/>'>
							</div>
							<div class="form-group">
								<label class="text-black">생년월일</label>
								<input type="text" class="form-control" name="m_birth"
									value='<c:out value="${member.m_birth}"/>'>
							</div>
							<div class="form-group">
								<label class="text-black">우편번호</label>
								<input type="text" class="form-control" name="m_zipcode"
									value='<c:out value="${member.m_zipcode}"/>'>
							</div>
							<div class="form-group">
								<label class="text-black">도로명주소</label>
								<input type="text" class="form-control" name="m_address1"
									value='<c:out value="${member.m_address1}"/>'>
							</div>
							<div class="form-group">
								<label class="text-black">지번주소</label>
								<input type="text" class="form-control" name="m_address2"
									value='<c:out value="${member.m_address2}"/>'>
							</div>
							<div class="form-group">
								<label class="text-black">상세 주소</label>
								<input type="text" class="form-control" name="m_restAddress"
									value='<c:out value="${member.m_restAddress}"/>'>
							</div>
	
						<button type="submit" data-oper="update" class="btn btn-primary-hover-outline">저장하기</button>
						<button type="submit" data-oper="delete" class="btn btn-primary-hover-outline">회원탈퇴</button>
						<button type="submit" data-oper="list" class="btn btn-primary-hover-outline">목록보기</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function() {


	  var formObj = $("form");

	  $('button').on("click", function(e){
	    
	    e.preventDefault(); 
	    
	    var operation = $(this).data("oper");
	    
	    console.log(operation);
	    
	    if(operation === 'delete'){
	      formObj.attr("action", "/member/delete");
	      
	    }else if(operation === 'list'){
	      //move to list
	      formObj.attr("action","/member/list").attr("method","get");
	      formObj.empty();
	    }
	    formObj.submit();
	  });

});
</script>

</body>
</html>