<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">~*~*</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">상품수정</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

      <form role="form" action="/product/modify" method="post">

 
<div class="form-group">
  <label>상품번호</label> 
  <input class="form-control" name='p_num' 
     value='<c:out value="${productVO.p_num }"/>' readonly="readonly">
</div>

<div class="form-group">
  <label>상품명</label> 
  <input class="form-control" name='p_name' 
    value='<c:out value="${productVO.p_name  }"/>' >
</div>

<div class="form-group">
  <label>상품설명</label>
  <textarea class="form-control" rows="3" name='p_desc' ><c:out value="${productVO.p_desc}"/></textarea>
</div>

<div class="form-group">
  <label>카테고리</label> 
  <input class="form-control" name='p_cate'
    value='<c:out value="${productVO.p_cate}"/>' >            
</div>

<div class="form-group">
  <label>상품수량</label> 
  <input class="form-control" name='p_quantity'
    value='<c:out value="${productVO.p_quantity}"/>'>            
</div>


<div class="form-group">
  <label>사이즈</label> 
  <input class="form-control" name='p_size'
    value='<c:out value="${productVO.p_size}"/>' >            
</div>


<div class="form-group">
  <label>가격</label> 
  <input class="form-control" name='p_price'
    value='<c:out value="${productVO.p_price}"/>'>            
</div>


<div class="form-group">
  <label>색상</label> 
  <input class="form-control" name='p_color'
    value='<c:out value="${productVO.p_color}"/>'>            
</div>          

  <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
  <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
  <button type="submit" data-oper='list' class="btn btn-info">List</button>
</form>


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


	  var formObj = $("form");

	  $('button').on("click", function(e){
	    
	    e.preventDefault(); 
	    
	    var operation = $(this).data("oper");
	    
	    console.log(operation);
	    
	    if(operation === 'remove'){
	      formObj.attr("action", "/product/remove");
	      
	    }else if(operation === 'list'){
	      //move to list
	      formObj.attr("action", "/product/list").attr("method","get");
	      
	      var pageNumTag = $("input[name='pageNum']").clone();
	      var amountTag = $("input[name='amount']").clone();
	      var keywordTag = $("input[name='keyword']").clone();
	      var typeTag = $("input[name='type']").clone();      
	      
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