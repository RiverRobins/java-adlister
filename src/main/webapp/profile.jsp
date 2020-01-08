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
    <title>Profile</title>
</head>
<body>
</body>

<c:choose>
    <c:when test="${param.username == 'admin' && param.password == 'password'}">

    </c:when>
    <c:otherwise>
        <c:redirect url="./login.jsp">

        </c:redirect>
    </c:otherwise>
</c:choose>

</html>
