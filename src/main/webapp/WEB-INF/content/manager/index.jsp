
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>经理首页</title>
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
<%@include file="mgrheader.jsp"%>
<div class="container">
  <div class="card m-2">
	<div class="card-header">
	  <h3 class="card-title">提示信息</h3>
	</div>
	<div class="card-body">
	  <p>&nbsp;</p>
	  <p>&nbsp;</p>
	  <c:if test="${not empty tip}">
		<div class="text-center text-primary">${tip}</div>
	  </c:if>
	  <p class="text-center">${sessionScope.user}，
	    欢迎您使用JavaEE简单工作流系统，您的权限是--------------经理-----------------
	  </p>
	  <p>&nbsp;</p>
	  <p>&nbsp;</p>
	</div>
  </div>
</div>
</body>
</html>