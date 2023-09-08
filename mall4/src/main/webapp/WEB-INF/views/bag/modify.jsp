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
					<form role="form" action="/bag/modify" method="post">
						<h2>상품 수정</h2>
						<div class="row">
							<div class="form-group">
								<label class="text-black">상품번호</label> <input type="text"
									class="form-control" name="p_num" readonly="readonly"
									value='<c:out value="${bagProductVO.p_num}"/>'>
							</div>
							<div class="form-group">
								<label class="text-black">상품명</label> <input type="text"
									class="form-control" name="p_name" 
									value='<c:out value="${bagProductVO.p_name}"/>'>
							</div>
							<div class="form-group">
								<label class="text-black">가격</label> <input type="text"
									class="form-control" name="p_price" 
									value='<c:out value="${bagProductVO.p_price}"/>'>
							</div>
						</div>
						<div class="form-group">
							<label class="text-black">수량</label> <input type="text"
								class="form-control" name="p_quantity"
								value='<c:out value="${bagProductVO.p_quantity}"/>'>
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
							<label class="text-black">사이즈</label> <select class="form-select"
								name="p_size" >
								<option>S</option>
								<option>M</option>
								<option>L</option>
							</select>
						</div>
						<div class="form-group">
							<label class="text-black" for="name">상품설명</label>
							<textarea class="form-control" name="p_desc" cols="30" rows="5"
								><c:out
									value="${bagProductVO.p_desc}" /></textarea>
						</div>
						<div class="form-group  mb-5">
							<label class="text-black">색상</label> <input type="text"
								class="form-control" name="p_color"
								value='<c:out value="${bagProductVO.p_color}"/>'>
						</div>
						<button type="submit" data-oper="modify" class="btn btn-primary-hover-outline">저장하기</button>
						<button type="submit" data-oper="remove" class="btn btn-primary-hover-outline">삭제하기</button>
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
	    
	    if(operation === 'remove'){
	      formObj.attr("action", "/bag/remove");
	      
	    }else if(operation === 'list'){
	      //move to list
	      formObj.attr("action","/bag/list").attr("method","get");
	      formObj.empty();
	    }
	    formObj.submit();
	  });

});
</script>



</div>
</div>
</div>
</div>
</div>
</div>

</body>
</html>