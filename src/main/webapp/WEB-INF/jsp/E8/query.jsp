<jsp:useBean id="user" scope="request" type="com.experiment8.entity.User"/>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>详细信息</h2>
用户ID：${user.id } <br>
用户名：${user.name } <br>
添加时间：${user.insertTime }
</body>

</html>