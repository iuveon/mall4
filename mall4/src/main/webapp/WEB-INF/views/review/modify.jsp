<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../includes/header.jsp"%>

	<!-- Start Contact Form -->
	<div class="untree_co-section">
		<div class="container">
			<div class="block">
				<div class="row justify-content-center">
					<div class="col-md-8 col-lg-8 pb-4">
						<h2>게시글 내용 조회</h2>
					
							<div>
								<form action="/review/modify" method="post">
								
								<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
								<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
								<input type="hidden" name="type" value='<c:out value="${cri.type}"/>'>
								<input type="hidden" name="keyword" value='<c:out value="${cri.keyword}"/>'>
								
									<div class="form-group"><label class="text-black">번호</label><input type="text" class="form-control" name="b_num" value='<c:out value="${review.b_num}"/>' readonly="readonly"></div>
									<div class="form-group"><label class="text-black">제목</label><input type="text" class="form-control" name="b_title" value='<c:out value="${review.b_title}"/>'></div>
									<div class="form-group"><label class="text-black">내용</label><textarea class="form-control" name="b_content" rows="3"><c:out value="${review.b_content}"/></textarea></div>
									<div class="form-group"><label class="text-black">작성자</label><input type="text" class="form-control" name="b_writer" value='<c:out value="${review.b_writer}"/>' readonly="readonly"></div>
									<div class="form-group"><label class="text-black">등록일</label><input type="text" class="form-control" name="b_regdate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${review.b_regdate}"/>' readonly="readonly"></div>
									<div class="form-group mb-5"><label class="text-black">수정일</label><input type="text" class="form-control" name="b_editdate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${review.b_editdate}"/>' readonly="readonly"></div>
									
									<button type="submit" id="modBtn" data-oper="modify" class="btn btn-xs pull-right">수정하기</button>
									<button type="submit" id="delBtn" data-oper="remove" class="btn btn-xs pull-right">삭제하기</button>
									<button type="submit" id="rtnBtn" data-oper="list" class="btn btn-xs pull-right">돌아가기</button>
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
// 버튼의 data-oper에 따라 다른 페이지로 이동
$(document).ready(function() {
	var formObj = $("form");
	
	$('button').on("click", function(e){
		e.preventDefault();
		var operation = $(this).data("oper");
		
		// data-oper="remove"인 경우 remove 페이지로 이동
		if(operation === 'remove') {
			formObj.attr("action", "/review/remove");
			
		// data-oper="list"인 경우 list 페이지로 이동
		} else if(operation === 'list') {
			formObj.attr("action", "/review/list").attr("method", "get");
			
			// clone() : 선택한 요소를 복제
			var pageNumTag = $("input[name='pageNum']").clone();	
			var amountTag = $("input[name='amount']").clone();
			var keywordTag = $("input[name='keyword']").clone();
			var typeTag = $("input[name='type']").clone();
			
			// empty() : 선택된 요소의 하위요소 제거
			formObj.empty();
			
			formObj.append(pageNumTag);
			formObj.append(amountTag);
			formObj.append(keywordTag);
			formObj.append(typeTag);
		}
		
		formObj.submit();
	});
});
</script>
</html>