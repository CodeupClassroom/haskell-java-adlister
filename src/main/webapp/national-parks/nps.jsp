<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jayarredondo
  Date: 11/2/22
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>National Parks</title>
</head>
<body>
  <h1>National Parks</h1>
  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam consectetur culpa, cupiditate ipsum iure laboriosam modi sequi similique sit veritatis.</p>
<%--    <ul>--%>
<%--        <c:forEach items="${nationalParkList}" var="nationalPark">--%>
<%--            <li>${nationalPark}</li>--%>
<%--        </c:forEach>--%>
<%--    </ul>--%>
    <h4>${myDog.getName()}</h4>
    <p>${myDog.getBreed()}</p>
    <p>${myDog.getAge()}</p>

</body>
</html>
