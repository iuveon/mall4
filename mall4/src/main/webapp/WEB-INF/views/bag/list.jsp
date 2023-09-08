<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

		<div class="untree_co-section product-section before-footer-section">
		    <div class="container">
		    	<div class="panel-heading mb-5">
		    		<button id="regBtn" type="button" class="btn btn-xs pull-right">상품 등록</button>
		    	</div>
		      	<div class="row">
					<c:forEach items="${list}" var="BagProductVO">
		      		<!-- Start Column 1 -->
					<div class="col-12 col-md-4 col-lg-3 mb-5">
						<a class="product-item" href="#">
							<!-- <thread>
								<img src="images/product-3.png" class="img-fluid product-thumbnail">
								<h3 class="p_name">가방이름</h3>
								<strong class="p_price">가격</strong>
								<span class="icon-cross"> 이미지테이블 생성시 반영예정
									<img src="images/cross.svg" class="img-fluid">
								</span>
							</thread>
							 -->
								<img src="../../../../resources/images/product-1.jpg" class="img-fluid product-thumbnail">
								<h3><c:out value="${ BagProductVO.p_name}"></c:out></h3>
								<strong><c:out value="${ BagProductVO.p_price}"></c:out></strong>
								<span class="icon-cross"> <!-- 이미지테이블 생성시 반영예정 -->
									<img src="../../../../resources/images/cross.svg" class="img-fluid">
								</span>				
							
						</a>
					</div> 
					<!-- End Column 1 -->
					</c:forEach>
		      	</div>
		    </div>
		</div>
		
					<!-- Modal  추가 -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Modal title</h4>
						</div>
						<div class="modal-body">처리가 완료되었습니다.</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Save
								changes</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
</body>
</html>