<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <div class="container">
        <%--Using sessionScope implicit object to access session attribute by name--%>
        <h1>Viewing ${sessionScope.username}'s profile.</h1>
    </div>

</body>
</html>
