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
						<h2>새 게시글 등록</h2>
						
						<div>
							<form action="/review/register" method="post">
								<div class="form-group"><label class="text-black">제목</label><input type="text" class="form-control" name="b_title"></div>
								<div class="form-group"><label class="text-black">내용</label><textarea class="form-control" name="b_content" rows="3"></textarea></div>
								<div class="form-group mb-5"><label class="text-black">작성자</label><input type="text" class="form-control" name="b_writer"></div>
								<button type="submit" class="btn btn-xs pull-right">작성 완료</button>
								<button type="reset" class="btn btn-xs pull-right">되돌리기</button>
								<button type="button" class="btn btn-xs pull-right" onclick="history.back()">작성 취소</button>	
							</form>
						</div>
	
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>

</html>