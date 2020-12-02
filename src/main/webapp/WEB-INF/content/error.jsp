
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>出错提示</title>
</head>
<body>
  <div class="container">
    <div class="card m-2 text-center">
      <div class="card-header">
        <h4>系统处理过程中发生了一个错误，信息如下：</h4>
      </div>
      <div class="card-body">
        <p>&nbsp;</p>
        <div class="text-danger">${ex.message}</div>
        <p>&nbsp;</p>
      </div>
    </div>
  </div>
</body>
</html>