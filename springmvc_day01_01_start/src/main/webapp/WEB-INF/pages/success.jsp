<%--
  Created by IntelliJ IDEA.
  User: dingxiaoqi5
  Date: 2020/10/14
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

   <h3>入门成功</h3>
   ${requestScope.get("msg")}
   ${sessionScope}

</body>
</html>
