<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>

<div class="untree_co-section product-section before-footer-section">
    <div class="container">
    	<div class="panel-heading mb-5">
    		<button id="regBtn" type="button" class="btn btn-xs pull-right">회원 목록</button>
    	</div>
      	<div class="row">
			<c:forEach items="${list}" var="member">
      		<!-- Start Column 1 -->
			<div class="col-12 col-md-4 col-lg-3 mb-5">
				<a class="product-item" href="/member/info?m_id=<c:out value="${member.m_id }"/>">

						<h3><c:out value="${ member.m_id }"/></h3>
						<strong><c:out value="${ member.m_name}"/></strong>
						<strong><c:out value="${ member.m_phone }"/></strong>		
					
				</a>
			</div> 
			<!-- End Column 1 -->
			</c:forEach>
      	</div>
    </div>
</div>

	
</body>

</html>