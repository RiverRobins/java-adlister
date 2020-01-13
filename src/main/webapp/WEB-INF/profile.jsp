<%--<jsp:useBean id="username" scope="request" type="LoginServlet"/>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <div class="container">
        <h3>Welcome ${sessionScope.user}</h3>
        <h1>Viewing your profile.</h1>
    </div>

</body>
</html>
