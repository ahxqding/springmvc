<%--
  Created by IntelliJ IDEA.
  User: dingxiaoqi5
  Date: 2020/11/18
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="account/findAll">查找所有账户信息</a>
    <form action="account/save" method="post">
        姓名：<input type="text" name="name"/><br/>
        金额：<input type="text" name="money"><br/>
        <input type="submit" value="提交">
    </form>

</body>
</html>
