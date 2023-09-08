<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<!-- Start Contact Form -->
<div class="untree_co-section">
	<div class="container">
		<div class="block">
			<div class="row justify-content-center">
				<div class="col-md-8 col-lg-8 pb-4">
					<h2>상품 조회</h2>
					<div class="row">
						<div class="form-group">
							<label class="text-black">상품번호</label> <input type="text"
								class="form-control" name="p_num" readonly="readonly"
								value='<c:out value="${bagProductVO.p_num}"/>'>
						</div>
						<div class="form-group">
							<label class="text-black">상품명</label> <input type="text"
								class="form-control" name="p_name" readonly="readonly"
								value='<c:out value="${bagProductVO.p_name}"/>'>
						</div>
						<div class="form-group">
							<label class="text-black">가격</label> <input type="text"
								class="form-control" name="p_price" readonly="readonly"
								value='<c:out value="${bagProductVO.p_price}"/>'>
						</div>
					</div>
					<div class="form-group">
						<label class="text-black">수량</label> <input type="text"
							class="form-control" name="p_quantity" readonly="readonly"
							value='<c:out value="${bagProductVO.p_quantity}"/>'>
					</div>
					<div class="form-group">
						<label class="text-black">카테고리</label> <select class="form-select"
							name="p_cate" disabled="disabled">
							<option><c:out value="${bagProductVO.p_cate}" /></option>
						</select>
					</div>
					<div class="form-group">
						<label class="text-black">사이즈</label> <select class="form-select"
							name="p_size" disabled="disabled">
							<option><c:out value="${bagProductVO.p_size}" /></option>
						</select>
					</div>
					<div class="form-group">
						<label class="text-black" for="name">상품설명</label>
						<textarea class="form-control" name="p_desc" cols="30" rows="5"
							disabled="disabled"> <c:out
								value="${bagProductVO.p_desc}" /></textarea>
					</div>
					<div class="form-group  mb-5">
						<label class="text-black">색상</label> <input type="text"
							class="form-control" name="p_color" readonly="readonly"
							value='<c:out value="${bagProductVO.p_color}"/>'>
					</div>
					<button data-oper="modify"
						onclick="location.href='/bag/modify?p_num=<c:out value="${bagProductVO.p_num}"/>'"
						class="btn btn-primary-hover-outline">수정하기</button>
					<button data-oper="list" onclick="location.href='/bag/list'"
						class="btn btn-primary-hover-outline">목록보기</button>
					<form id="operForm" action="/bag/modify" method="get">
						<input type="hidden" id="p_num" name="p_num"
							value="<c:out value='${bagProductVO.p_num}'/>">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>


</div>
</div>
</div>
</div>
</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		var operForm = $("#operForm");

		$("button[data-oper='modify']").on("click", function(e) {

			operForm.attr("action","/bag/modify").submit();

		});

		$("button[data-oper='list']").on("click", function(e) {

			operForm.find("#p_num").remove();
			operForm.attr("action","/bag/list")
			operForm.submit();

		});
	});
</script>
</body>
</html>