<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>colors</title>
    <jsp:include page="partials/style.jsp"/>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>

<form method="post" action="color.jsp">
    <label for="color">Enter a color...</label>
    <input type="text" id="color" name="color">
    <button type="submit">Submit</button>
</form>

<jsp:include page="partials/footer.jsp"/>
</body>
</html>
