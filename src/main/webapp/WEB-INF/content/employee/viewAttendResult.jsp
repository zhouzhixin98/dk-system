<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>打卡异动申请批复结果</title>
</head>
<body>

    <div class="container">
        <div>
            <h3 class="card-title">
                当前用户：${sessionScope.user}
            </h3>
        </div>
        <div>
            <table>
                <thead>
                <tr>
                    <th>打卡日期</th>
                    <th>异动名称</th>
                    <th>打卡时间</th>
                    <th>批复结果</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${apps}" var="im">
                    <tr>
                        <td>${im.dutyDay}</td>
                        <td>${im.unType}</td>
                        <td>
                                ${im.result}
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
