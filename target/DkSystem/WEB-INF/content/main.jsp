<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>打卡考勤管理系统</title>
</head>

<style type="text/css">
  body
    /*背景图*/
  {
    width:100%;
    height:100%;
    background-size:100% 100%;
    background: url(https://desk-fd.zol-img.com.cn/t_s1920x1080c5/g5/M00/02/05/ChMkJlbKyb6IYJGWAATekkst1RUAALISAEfBfMABN6q457.jpg) no-repeat fixed;
  }

  #title1{
    color: #faffff;
    text-shadow: 10px 10px 10px #93c2ff;
    text-align: center; /*设置文本水平居中*/
    overflow: hidden; /*防止内容超出容器或者产生自动换行*/
  }
  #container
  {
    border-style:inset;
    border-width: 20px;
    border-color: #ffc430;
    weight:500px;
    height:auto;
    text-align: center; /*设置文本水平居中*/
    background-color: #f8ff7b;
  }
  /*登录按钮*/
  #login{
    display: inline-block;
    border-radius: 4px;
    background-color: #79d8f4;
    border: none;
    color: #fffafe;
    text-align: center;
    font-size: 28px;
    padding: 20px;
    width: 200px;
    transition: all 0.5s;
    cursor: pointer;
    margin: 5px;
  }
  #login span {
    cursor: pointer;
    display: inline-block;
    position: relative;
    transition: 0.5s;
  }
  #login span:after {
    content: '»';
    position: absolute;
    opacity: 0;
    top: 0;
    right: -20px;
    transition: 0.5s;
  }
  #login:hover span {
    padding-right: 25px;
  }
  #login:hover span:after {
    opacity: 1;
    right: 0;
  }

  #img
   {
     left: 30%;
    top: auto;
   }
</style>
<body οnlοad="startTime()">
  <div id="title1">
    <h1>打卡考勤管理系统</h1>
  </div>
  <div id="container">
      <h1>打卡考勤查询管理系统</h1>
      <p>这是一个Java EE的框架程序。应用模拟一个简单的工作流系统。系统包含两个角色，普通员工的功能包括员工出勤打卡，员工的人事异动申请，员工查看工资单。经理的功能包括管理部门员工，签核申请，每月工资自动结算等。应用模拟了简单的工作流，使用的轻量级Java EE架构。技术包括：Spring MVC 5.1、Spring 5.1、MyBatis 3.5、Quartz 2.3，整个应用使用Spring提供的DAO支持操作数据库，同时利用Spring的声明式事务。程序中的权限检查使用Spring的AOP框架支持，也利用了Spring的任务调度抽象，MyBatis为底层的数据库访问提供支持,作为SQL Mapping框架使用。
        <br/><a href="http://www.baidu.com" >百度</a>
      </p>
      <button id="login" style="vertical-align:middle">
        <span>
        <a class="btn btn-primary btn-lg" href="login" role="button" >登录系统</a>
        </span>
      </button>
  </div>
  <div>
  <div id="img">
    <img src="https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg"
        alt="Spring" height="150px" width="300"/>
  </div>
  </div>
  <script type="text/javascript">
      var today=new Date();
      function initArray(){
          this.length=initArray.arguments.length
          for(var i=0;i<this.length;i++)
              this[i+1]=initArray.arguments[i]}
      var d=new initArray(
          "星期日","星期一","星期二","星期三","星期四","星期五","星期六");
      document.write(

          today.getFullYear(),"年",
          today.getMonth()+1,"月",
          today.getDate(),"日",
          d[today.getDay()+1]
      );
  </script> <br />
</body>
</html>