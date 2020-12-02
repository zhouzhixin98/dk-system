

<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>查看本部门上个月的发薪</title>
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
	  <h3 class="card-title">
	    查看上个月部门的全部工资</h3>
	</div>
	<div class="card-body">
	  <table class="table table-hover">
		<thead>
		  <tr>
			<th>员工名</th>
			<th>薪水</th>
		  </tr>
		</thead>
		<tbody>
		  <c:forEach items="${sals}" var="sa">
			<tr>
			  <td>${sa.empName}</td>
			  <td>${sa.amount}</td>
			</tr>
		  </c:forEach>
		</tbody>
	  </table>
	</div>
  </div>
</div>
</body>
</html>