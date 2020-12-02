

<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>增加新员工</title>
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
	  <h3 class="card-title">请您输入新员工的资料</h3>
	</div>
	<div class="card-body">
	  <form action="processAdd" method="post">
		<div class="form-group row">
		  <label for="name" class="col-sm-2 control-label">员工用户名：</label>
		  <div class="col-sm-7">
			<input type="text" class="form-control" id="name" 
			  name="name" placeholder="请输入员工用户名">
		  </div>
		  <div class="col-sm-3 text-danger">
		    <form:errors path="employee.name"/>
		  </div>
		</div>
		<div class="form-group row">
		  <label for="pass" class="col-sm-2 control-label">员工密码：</label>
		  <div class="col-sm-7">
			<input type="text" class="form-control" id="pass" 
			  name="pass" placeholder="请输入员工密码">
		  </div>
		  <div class="col-sm-3 text-danger">
		    <form:errors path="employee.pass"/>
		  </div>
		</div>
		<div class="form-group row">
		  <label for="salary" class="col-sm-2 control-label">员工月薪：</label>
		  <div class="col-sm-7">
			<input type="text" class="form-control" id="salary"
			  name="salary" placeholder="请输入员工月薪">
		  </div>
		  <div class="col-sm-3 text-danger">
		    <form:errors path="employee.salary"/>
		  </div>
		</div>
		<div class="form-group row">
		  <div class="col-sm text-center">
			<button type="submit" class="btn btn-primary">添加新员工</button>
			<button type="reset" class="btn btn-danger">重新输入</button>
		  </div>
		</div>
	  </form>
	</div>
  </div>
</div>
</body>
</html>
