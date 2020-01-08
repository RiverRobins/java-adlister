<%--
  Created by IntelliJ IDEA.
  User: imac
  Date: 1/7/20
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="POST" action="./profile.jsp">
    <input type="text" id="username" name="username">
    <label for="username">Enter username: </label>
    <input type="password" id="password" name="password">
    <label for="password">Enter password: </label>
    <button type="submit">Login</button>
</form>
</body>
</html>
