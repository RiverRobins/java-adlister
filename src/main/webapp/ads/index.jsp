<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
<%--    <jsp:include page="//partials/style.jsp"/>--%>
</head>
<body>
<%--<jsp:include page="/partials/navbar.jsp"/>--%>

<div id="ads-list" class="center">
<%--    ads generate here--%>
    <jsp:useBean id="ads" scope="request" type="java.util.List"/>
    <c:forEach var="ad" items="${ads}">
        <div class="ad-card">
            <img src="" alt="pic">
            <div class="ad-info">
                <h6 class="ad-title">
                    ${ad.title}
                </h6>
                <p class="ad-description">
                    ${ad.description}
                </p>
            </div>
        </div>
    </c:forEach>
</div>

<%--<jsp:include page="//partials/footer.jsp"/>--%>
</body>
</html>
