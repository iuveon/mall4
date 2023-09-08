<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<script type="text/javascript">
	$(document).ready(funcion(){
		var result = '<c:out value="${result}"/>';
	});
</script>
<!-- Start Contact Form -->
<div class="untree_co-section">
	<div class="container">
		<div class="block">
			<div class="row justify-content-center">
				<div class="col-md-8 col-lg-8 pb-4">
					<form action="/bag/register" method="post">
						<h2>상품 등록</h2>
						<div class="row">
							<div class="form-group">
								<label class="text-black">상품명</label> <input type="text"
									class="form-control" name="p_name">
							</div>
							<div class="form-group">
								<label class="text-black">가격</label> <input type="text"
									class="form-control" name="p_price">
							</div>
						</div>
						<div class="form-group">
							<label class="text-black">수량</label> <input type="text"
								class="form-control" name="p_quantity">
						</div>
						<div class="form-group">
							<label class="text-black">카테고리</label> <select
								class="form-select" name="p_cate">
								<option>백팩</option>
								<option>슬링백</option>
								<option>숄더백</option>
								<option>버킷백</option>
								<option>쇼퍼백</option>
								<option>토드백</option>
								<option>미니백</option>
								<option>크로스백</option>
							</select>
						</div>
						<div class="form-group">
							<label class="text-black">사이즈</label> <select
								class="form-select" name="p_size">
								<option>S</option>
								<option>M</option>
								<option>L</option>
							</select>
						</div>
						<div class="form-group">
							<label class="text-black" for="name">상품설명</label>
							<textarea class="form-control" name="p_desc" cols="30" rows="5"></textarea>
						</div>
						<div class="form-group  mb-5">
							<label class="text-black">색상</label> <input type="text"
								class="form-control" name="p_color">
						</div>
						<button type="submit" class="btn btn-primary-hover-outline">작성하기</button>
						<button type="reset" class="btn btn-primary-hover-outline">다시하기</button>
				</div>
			</div>
		</div>
	</div>
</div>

</form>
</div>
</div>
</div>
</div>
</div>
</div>

</body>
</html>