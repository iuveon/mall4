<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 후기 게시판</title>
<style>
	ul {
		list-style:none;
	}
	
	li {
		float:left;
		margin-right:20px;
	}
</style>
</head>
<body>
	<div><button id="regBtn" type="button">상품 후기 등록</button></div>

	<!-- 게시판 테이블 -->
	<table border="1">
		<tr>
			<th>#번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>수정일</th>
		</tr>
	
	<c:forEach items="${list}" var="review">
		<tr>
			<td><c:out value="${review.b_num}"></c:out></td>
			<td><a class="move" href='<c:out value="${review.b_num}"/>'><c:out value="${review.b_title}"/></a></td>
			<td><c:out value="${review.b_writer}"></c:out></td>
			<td><fmt:formatDate type="both" dateStyle="long" value="${review.b_regdate}"/></td>
			<td><fmt:formatDate type="both" dateStyle="long" value="${review.b_editdate}"/></td>
		</tr>
	</c:forEach>
	
	</table>
	
	<!-- 검색 기능 -->
	<div>
		<form id="searchForm" action="/review/list" method="get">
			<select name="type">
				<option value="" <c:out value="${pageMaker.cri.type == null ? 'selected' : ''}"/>>--</option>
				<option value="T" <c:out value="${pageMaker.cri.type == 'T' ? 'selected' : ''}"/>>제목</option>
				<option value="C" <c:out value="${pageMaker.cri.type == 'C' ? 'selected' : ''}"/>>내용</option>
				<option value="W" <c:out value="${pageMaker.cri.type == 'W' ? 'selected' : ''}"/>>작성자</option>
				<option value="TC" <c:out value="${pageMaker.cri.type == 'TC' ? 'selected' : ''}"/>>제목 OR 내용</option>
				<option value="TW" <c:out value="${pageMaker.cri.type == 'TW' ? 'selected' : ''}"/>>내용 OR 작성자</option>
				<option value="TWC" <c:out value="${pageMaker.cri.type == 'TWC' ? 'selected' : ''}"/>>제목 OR 내용 OR 작성자</option>
			</select>
			
			<!-- 검색한 후에 검색어가 페이지에 남아 있도록 값 저장 -->
			<input type="text" name="keyword" value='<c:out value="${pageMaker.cri.keyword}"/>'>
			
			<!-- 검색했을 때 나오는 총 페이지 수와 게시글 수의 값 전달 -->
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
			<button>검색</button>
		</form>
	</div>
	
	<!-- 페이징 기능 -->
	<div>
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li class="paginate_button previous"><a href="${pageMaker.startPage - 1}">[이전으로]</a></li>
			</c:if>
			
			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				<li class="paginate_button"><a href="${num}">${num}</a></li>
			</c:forEach>
			
			<c:if test="${pageMaker.next}">
				<li class="paginate_button next"><a href="${pageMaker.endPage + 1}">[다음으로]</a></li>
			</c:if>
		</ul>
	</div>
	
	<!-- 페이징 기능 폼 태그 : 제이쿼리 연동 -->
	<form id="actionForm" action="/review/list" method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
		<input type="hidden" name="type" value='<c:out value="${pageMaker.cri.type}"/>'>
		<input type="hidden" name="keyword" value='<c:out value="${pageMaker.cri.keyword}"/>'>
	</form>
	
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>	

<script>
$(document).ready(function() {
	// 상품 후기 등록 버튼 클릭 시 register 페이지로 이동
	$("#regBtn").on("click", function(){
		self.location = "/review/register";
	});
	
	var actionForm = $("#actionForm");
	
	// 페이지 번호 클릭 시 a 태그의 href 속성이 작동하는 것을 방지
	$(".paginate_button a").on("click", function(e) {
		e.preventDefault();
		
		// id="actionForm"인 form 태그의 name="pageNum"의 value 값을
		// li 태그의 href 속성의 값으로 변경
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
	
	// 게시글 제목 클릭 시 a 태그의 href 속성이 작동하는 것을 방지
	$(".move").on("click", function(e){
		e.preventDefault();
		
		// id="actionForm"인 form 태그에 input 태그를 추가
		// hidden 속성으로 move 클래스의 ${review.b_num} 값을 저장
		actionForm.append("<input type='hidden' name='b_num' value='" + $(this).attr("href") + "'>");
		actionForm.attr("action", "/review/get");
		actionForm.submit();
	});
	
	
	var searchForm = $("#searchForm");
	
	$("#searchForm button").on("click", function(e){
		// 옵션의 종류가 선택되지 않은 경우(null) 팝업 경고를 띄움
		if(!searchForm.find("option:selected").val()) {
			alert("검색 종류를 선택하세요.");
			return false;
		}
		
		// 검색어에 값이 입력되지 않은 경우 팝업 경고를 띄움
		if(!searchForm.find("input[name='keyword']").val()) {			
			alert("키워드를 입력하세요.");
			return false;
		}
		
		// 검색할 때 현재 페이지 번호 값에 1을 전달
		searchForm.find("input[name='pageNum']").val("1");
		
		// e.preventDefault();
		
		// searchForm.submit();
	});
});
</script>

</body>
</html>