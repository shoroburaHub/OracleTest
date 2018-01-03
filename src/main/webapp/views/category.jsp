<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/31/2017
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${category.name}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <table class="table table-hover">
        <h3>${category.name}</h3>
        <tr>
            <th>id</th>
            <th>sub category name</th>
            <th><a href="/random/${category.id}">random 25</a></th>
        </tr>
        <c:forEach items="${category.subcategorys}" var="subcategory">
            <tr>
                <td>${category.id}</td>
                <td>${subcategory.name}</td>
                <td><a href="/subcategory/${subcategory.id}">go to</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>