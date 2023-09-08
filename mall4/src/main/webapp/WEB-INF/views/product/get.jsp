<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">상품상세</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">~*~</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

          <div class="form-group">
          <label>상품번호</label> <input class="form-control" name='p_num'
            value='<c:out value="${productVO.p_num }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>가격</label> <input class="form-control" name='p_price'
            value='<c:out value="${productVO.p_price}"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>상품설명</label>
          <textarea class="form-control" rows="3" name='p_desc'
            readonly="readonly"><c:out value="${productVO.p_desc}" /></textarea>
        </div>

        <div class="form-group">
          <label>잔여수량</label> <input class="form-control" name='p_quantity'
            value='<c:out value="${productVO.p_quantity}"/>' readonly="readonly">
        </div>
        
        <div class="form-group">
          <label>사이즈</label> <input class="form-control" name='p_size'
            value='<c:out value="${productVO.p_size}"/>' readonly="readonly">
        </div>
        
        <div class="form-group">
          <label>카테고리</label> <input class="form-control" name='p_cate'
            value='<c:out value="${productVO.p_cate}"/>' readonly="readonly">
        </div>
        
        <div class="form-group">
          <label>색상</label> <input class="form-control" name='p_color'
            value='<c:out value="${productVO.p_color}"/>' readonly="readonly">
        </div>

<%-- 		<button data-oper='modify' class="btn btn-default">
        <a href="/board/modify?bno=<c:out value="${board.bno}"/>">Modify</a></button>
        <button data-oper='list' class="btn btn-info">
        <a href="/board/list">List</a></button> --%>


<button data-oper='modify' onclick="location.href='/product/modify?p_num=<c:out value="${productVO.p_num}"/>'" class="btn btn-default">Modify</button>
<button data-oper='list' class="btn btn-info" onclick="location.href='/product/list'">List</button>

<%-- <form id='operForm' action="/boad/modify" method="get">
  <input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
</form> --%>




      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {
  
  var operForm = $("#operForm"); 
  
  $("button[data-oper='modify']").on("click", function(e){
    
    operForm.attr("action","/product/modify").submit();
    
  });
  
    
  $("button[data-oper='list']").on("click", function(e){
    
    operForm.find("#p_num").remove();
    operForm.attr("action","/product/list")
    operForm.submit();
    
  });  
});
</script>