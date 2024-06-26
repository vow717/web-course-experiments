<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<c:if test="${sessionScope.user!=null}" var="ifLogin">
    <div>
        <p>欢迎回来，您已登入，无需登入 </p><br>
        <a href="experiment5/welcome" style="text-decoration: none">点击进入</a>
    </div>
</c:if>
<c:if test="${sessionScope.user==null}" var="ifLogin">
<div>
    <p>请输入账号密码登入</p>
</div>
<form action="login" method="post">
    <input type="text" name="username" placeholder="账号wkf">
    <br>
    <input type="password" name="pwd" placeholder="密码123">
    <br>
    <button type="submit">submit</button>
</form>
<p style="color: red;">${sessionScope.error}</p>
<%  session.removeAttribute("error"); %>
</c:if>
<a href="welcome">测试：未登录重定向回本页</a>
</body>
</html>