<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/header.jsp"%>

	<!-- Start Contact Form -->
	<div class="untree_co-section">
		<div class="container">
			<div class="block">
				<div class="row justify-content-center">
					<div class="col-md-8 col-lg-8 pb-4">
						<h2>게시글 내용 조회</h2>
						
							<div>
								<div class="form-group"><label class="text-black">번호</label><input type="text" class="form-control" name="b_num" value='<c:out value="${review.b_num}"/>' readonly="readonly"></div>
								<div class="form-group"><label class="text-black"><strong>제목</strong></label><input type="text" class="form-control" name="b_title" value='<c:out value="${review.b_title}"/>' readonly="readonly"></div>
								<div class="form-group"><label class="text-black"><strong>내용</strong></label><textarea class="form-control" name="b_content" rows="3" readonly="readonly"><c:out value="${review.b_content}"/></textarea></div>
								<div class="form-group mb-5"><label class="text-black"><strong>작성자</strong></label><input type="text" class="form-control" name="b_writer" value='<c:out value="${review.b_writer}"/>' readonly="readonly"></div>
								
								<button id="modBtn" data-oper="modify" class="btn btn-primary-hover-outline">수정하기</button>
								<button id="rtnBtn" data-oper="list" class="btn btn-primary-hover-outline">돌아가기</button>
								
								<form id="operForm" action="/review/modify" method="get">
									<input type="hidden" id="b_num" name="b_num" value='<c:out value="${review.b_num}"/>'>
									<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
									<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
									<input type="hidden" name="type" value='<c:out value="${cri.type}"/>'>
									<input type="hidden" name="keyword" value='<c:out value="${cri.keyword}"/>'>
								</form>
							</div>
			
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>	

<script>
/*
 * operForm 폼 태그 만들기 전에 사용하던 기능
 *
$(document).ready(function() {
	// 수정하기 버튼 클릭 시 modify 페이지로 이동
	$("#modBtn").on("click", function(){
		self.location = "/review/modify?b_num=<c:out value="${review.b_num}"/>";
	});
	
	// 돌아가기 버튼 클릭 시 list 페이지로 이동
	$("#rtnBtn").on("click", function(){
		self.location = "/review/list";
	});
});
*/

$(document).ready(function() {
	var operForm = $("#operForm");
	
	// 수정하기 버튼 클릭 시 modify 페이지로 이동 (b_num 값을 함께 전송)
	$("button[data-oper='modify']").on("click", function(e){
		operForm.submit();
	});
	
	// 돌아가기 버튼 클릭 시 list 페이지로 이동 (b_num 값을 삭제)
	$("button[data-oper='list']").on("click", function(e) {
		operForm.find("#b_num").remove(); 					// remove() : 선택한 요소를 포함한 하위 요소 제거
		operForm.attr("action", "/review/list").submit();
	});
});
</script>
</html>