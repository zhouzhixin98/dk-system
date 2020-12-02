
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>查看自己的非正常出勤</title>
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
        当前用户：${sessionScope.user}</h3>
	</div>
	<div class="card-body">
	  <table class="table table-hover">
		<thead>
		  <tr>
			<th>打卡日期</th>
			<th>异动名称</th>
			<th>打卡时间</th>
			<th>操作</th>
		  </tr>
		</thead>
		<tbody>
		  <c:forEach items="${unAttends}" var="im">
			<tr>
			  <td>${im.dutyDay}</td>
			  <td>${im.unType}</td>
			  <td>
				<spring:eval expression="im.time" />
			  </td>
			  <td>
				<td>${im.unType}</td>
			  </td>
			</tr>
		  </c:forEach>
		</tbody>
	  </table>
	</div>
  </div>
</div>
</body>
</html>