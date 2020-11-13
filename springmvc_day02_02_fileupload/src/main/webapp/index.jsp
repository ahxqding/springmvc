<%--
  Created by IntelliJ IDEA.
  User: dingxiaoqi5
  Date: 2020/11/5
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h3>传统文件上传</h3>

   <form action="user/fileUpload1" method="post" enctype="multipart/form-data">
       <input type="file" value="选择文件" name="upload"/><br/>
       <input type="submit" value="上传" /><br/>
   </form>

   <h3>springmvc文件上传</h3>

   <form action="user/fileUpload2" method="post" enctype="multipart/form-data">
       <input type="file" value="选择文件" name="upload"/><br/>
       <input type="submit" value="上传" /><br/>
   </form>

   <h3>跨服务器文件上传</h3>

   <form action="user/fileUpload3" method="post" enctype="multipart/form-data">
       <input type="file" value="选择文件" name="upload"/><br/>
       <input type="submit" value="上传" /><br/>
   </form>

</body>
</html>
