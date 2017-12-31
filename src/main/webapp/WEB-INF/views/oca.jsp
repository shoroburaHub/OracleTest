<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/30/2017
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>oca</title>
</head>
<body>
oca
<br>
<table border="1">
    <caption>sub categories</caption>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>description</th>
        <th>test</th>
    </tr>
    <c:forEach items="${allSubCategories}" var="sub">
        <tr>
            <td>${sub.id}</td>
            <td>${sub.name}</td>
            <td>${sub.description}</td>
            <td><a href="/subcategory/${sub.id}">get test</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
