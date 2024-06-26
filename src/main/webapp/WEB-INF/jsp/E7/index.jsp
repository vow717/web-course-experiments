<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:useBean id="users" scope="request" type="java.util.List<com.experiment7.entity.User>"/>
<!DOCTYPE html>
<html>
<head>
    <c:url var="base" value="/"/>
    <base href="${base}">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>Query</h3>
全部用户
<ul>
    <c:forEach items="${users}" var="u">
        <li>${u.name}</li>
    </c:forEach>
</ul>
<hr>
<h3>Update</h3>
修改指定用户
<form action="experiment7/update" method="post">
    <select name="uid">
       <c:forEach items="${users}" var="u">
           <option value="${u.id}">${u.name}</option>
       </c:forEach>
    </select>
    新名字：<input type="text" name="newName" required>
    <br>
    <button type="submit">提交</button>
</form>
<hr>
<h3>Query</h3>
详细信息
<ul>
    <c:forEach items="${users}" var="u">
        <li><a href="experiment7/getuser?uid=${u.id}">${u.name}</a></li>
    </c:forEach>
</ul>
<hr>
<h3>Add</h3>
添加用户
<form action="experiment7/add" method="post">
    姓名:<input type="text" name="name">
    <button type="submit">添加</button>
</form>
<h3>Delete</h3>
删除用户
<form action="experiment7/delete" method="post">
    需要删除的用户姓名: <input type="text" name="name"><br>
    (删除不存在的用户名啥事没有发生)<br>
    <button type="submit" onclick="confirmDelete()">删除</button>
</form>

<script>
    function confirmDelete() {
        if (confirm("确定要删除吗？")) {
            // 如果用户确认删除，则提交表单
            document.getElementById("deleteForm").submit();
        } else {
            // 用户取消删除操作
            return false;
        }
    }
</script>
</body>
</html>
