<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2020, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>电子打卡</title>
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
	  <h3 class="card-title">电子打卡系统</h3>
	</div>
	<div class="card-body">
	  <p>&nbsp;</p>
	  <p>&nbsp;</p>
	  <div class="row">
		<div class="col-sm-12 text-center">
		  ${sessionScope.user}，
		</div>
	  </div>
	  <div class="row">
		<div class="col-sm-6 text-right">
		  <!-- 当punchIsValid为1、3时，可上班打卡 -->
		  <c:if test="${punchIsValid == 1 || punchIsValid == 3}">
			<a href="${pageContext.request.contextPath}/employeeCome"
			  class="btn btn-primary">上班打卡
			</a>
		  </c:if>
		</div>
		<div class="col-sm-6 text-left">
		  <!-- 当punchIsValid为2、3时，可下班打卡 -->
		  <c:if test="${punchIsValid == 2 || punchIsValid == 3}">
			<a href="${pageContext.request.contextPath}/employeeLeave"
			  class="btn btn-primary">下班打卡
			</a>
		  </c:if>
		</div>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
	  </div>
	</div>
  </div>
</div>
</body>
</html>