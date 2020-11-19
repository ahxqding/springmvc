<%--
  Created by IntelliJ IDEA.
  User: dingxiaoqi5
  Date: 2020/11/18
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>跳转成功</h3>
    <%--${list}--%>

    <c:forEach items="${list}" var="account">
        ${account.name}
    </c:forEach>

</body>
</html>
