<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>게시글 내용 조회</div>
	
	<div>
		<div><label>번호</label><input name="b_num" value='<c:out value="${review.b_num}"/>' readonly="readonly"></div>
		<div><label>제목</label><input name="b_title" value='<c:out value="${review.b_title}"/>' readonly="readonly"></div>
		<div><label>내용</label><textarea name="b_content" rows="3" readonly="readonly"><c:out value="${review.b_content}"/></textarea></div>
		<div><label>작성자</label><input name="b_writer" value='<c:out value="${review.b_writer}"/>' readonly="readonly"></div>
		
		<button id="modBtn" data-oper="modify">수정하기</button>
		<button id="rtnBtn" data-oper="list">돌아가기</button>
		
		<form id="operForm" action="/review/modify" method="get">
			<input type="hidden" id="b_num" name="b_num" value='<c:out value="${review.b_num}"/>'>
		</form>
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