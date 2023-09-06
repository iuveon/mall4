<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="header.jsp"%>

<!-- Start Contact Form -->
<div class="untree_co-section">
	<div class="container">
		<div class="block">
			<div class="row justify-content-center">
				<div class="col-md-8 col-lg-8 pb-4">
					<form>
						<div class="row">
							<div class="col-6">
								<div class="form-group">
									<label class="text-black" for="title">제목</label> <input
										type="text" class="form-control" id="title">
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label class="text-black" for="name">이름</label> <input
										type="text" class="form-control" id="name">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="text-black" for="email">이메일</label> <input
								type="email" class="form-control" id="email">
						</div>
						<div class="form-group mb-5">
							<label class="text-black" for="content">내용</label>
							<textarea name="" class="form-control" id="content" cols="30"
								rows="5"></textarea>
						</div>
						<button type="submit" class="btn btn-primary-hover-outline">작성하기</button>
						<button type="reset" class="btn btn-primary-hover-outline">다시하기</button>
					</form>

				</div>

			</div>

		</div>

	</div>


</div>
</div>

</body>
</html>