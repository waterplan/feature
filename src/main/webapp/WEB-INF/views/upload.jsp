<%--
  Created by IntelliJ IDEA.
  User: zengweipei
  Date: 2018/8/16
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/register" method="post" enctype="multipart/form-data">
    username:<input type="text" name="username"><br />
    要上传的文件:<input type="file" name="uploadFile"><br />
    <input type="submit" value="开始上传"><br />
</form>
</body>
</html>
