<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:useBean id="user" scope="request" type="com.experiment7.entity.User"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
用户id:${user.id}<br>
用户名称:${user.name}<br>
注册时间:${user.insertTime}<br>
</body>
</html>
