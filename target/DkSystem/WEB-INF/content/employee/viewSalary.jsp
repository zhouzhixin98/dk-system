
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>员工查看自己的工资</title>
</head>
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
			<th>发薪月份</th>
			<th>薪水</th>
		  </tr>
		</thead>
		<tbody>
		  <c:forEach items="${salarys}" var="sy">
			<tr>
			  <td>${sy.payMonth}</td>
			  <td>${sy.amount}</td>
			</tr>
		  </c:forEach>
		</tbody>
	  </table>
	</div>
  </div>
</div>
</body>
</html>