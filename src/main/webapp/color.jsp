<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= "color" %></title>
    <style>
        body{
            background-color: ${param.get("color")};
        }
    </style>
</head>
<body>

</body>
</html>