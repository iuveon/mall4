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
	</div>
</body>

<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>	

<script>
// 수정하기 버튼 클릭 시 modify 페이지로 이동
$(document).ready(function() {
	$("#modBtn").on("click", function(){
		self.location = "/review/modify?b_num=<c:out value="${review.b_num}"/>";
	});
});

// 돌아가기 버튼 클릭 시 list 페이지로 이동
$(document).ready(function() {
	$("#rtnBtn").on("click", function(){
		self.location = "/review/list";
	});
});
</script>
</html>