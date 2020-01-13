<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <jsp:include page="partials/head.jsp">--%>
<%--    <jsp:param name="title" value="Contacts"/>--%>
<%--    </jsp:include>--%>
</head>
<body>
<%--<jsp:include page="partials/navbar.jsp" />--%>
<div class="container">
    <h1>Contacts</h1>
    <div>
<%--        things go here--%>
        <jsp:useBean id="contacts" scope="request" type="java.util.List"/>
        <c:forEach var="contact" items="${contacts}">
            <p>${contact.firstName}</p>
            <p>${contact.lastName}</p>
            <p>${contact.number}</p>
        </c:forEach>
    </div>
</div>
</body>
</html>
