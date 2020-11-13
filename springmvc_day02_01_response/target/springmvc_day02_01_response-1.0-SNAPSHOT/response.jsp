<%--
  Created by IntelliJ IDEA.
  User: dingxiaoqi5
  Date: 2020/10/26
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载，绑定单击事件,由于前端控制器会拦截所有，会把静态资源当做请求去拦截，所以需要在xml文件中配置哪些静态资源不被拦截
        $(function () {
            $("#btn").click(function () {
                //发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"user/testAjax",//请求地址
                    contentType:"application/json;charset=UTF-8",//请求格式
                    data:'{"username":"hehe","password":"123","age":23}',//请求数据
                    dataType:"json",//预计服务器返回的数据类型
                    type:"post",//请求方式
                    success:function (data) {//请求成功后的回调函数
                        //服务器端相应的json数据
                        alert(JSON.stringify(data));
                    }
                });
            });
        });
    </script>
</head>
<body>

    <a href="user/testString">testString</a><br/>
    <a href="user/testVoid">testVoid</a><br/>
    <a href="user/testModelAndView">testModelAndView</a><br/>
    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a><br/>

    <button id="btn">发送ajax请求</button>

</body>
</html>
