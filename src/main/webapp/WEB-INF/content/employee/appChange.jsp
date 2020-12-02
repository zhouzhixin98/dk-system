

<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>提出异动申请</title>
</head>
<style>
	body
	{

		background-image:url("imgs/backgrounp.jpg");
		background-repeat:no-repeat;
		background-position:40% 0%;
		background-size: 30%  ;
	}
	.container
	{
		weight:500px;
		height:auto;
		text-align: center; /*设置文本水平居中*/
	}
</style>
<body>
<%@include file="empheader.jsp"%>
<div class="container">
  <div class="card m-2">
	<div class="card-header">
	  <h3 class="card-title">
        ${sessionScope.user}，请填写异动申请</h3>
	</div>
	<div class="card-body">
	  <form action="processApp" method="post">
		<input type="hidden" name="attId" value="${attId}" />
		<div class="form-group row">
		  <label for="type_id" class="col-sm-2 control-label">申请类别：</label>
		  <div class="col-sm-7">
			<select type="text" class="form-control" id="type_id"
			  name="typeId" placeholder="用户名">
			  <c:forEach items="${types}" var="ty">
				<option value="${ty.id}">${ty.name}</option>
			  </c:forEach>
			</select>
		  </div>
		</div>
		<div class="form-group row">
		  <label for="reason" class="col-sm-2 control-label">申请理由：</label>
		  <div class="col-sm-7">
			<textarea class="form-control" id="reason" rows="4" col="20"
			  name="reason" placeholder="填写申请理由"></textarea>
		  </div>
		  <div class="col-sm-3">
		  </div>
		</div>
		<div class="form-group row">
		  <div class="col-sm text-center">
			<button type="submit" class="btn btn-primary">提交申请</button>
			<button type="reset" class="btn btn-danger">重填</button>
		  </div>
		</div>
	  </form>
	</div>
  </div>
</div>
</body>
</html>