<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/30/2017
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>sub category</title>
    <style>

    </style>
</head>
<body>
<table border="1">
    <caption><h3>number of question = ${questions.size()}</h3></caption>
    <tr>
        <th>toughness</th>
        <th>problemStatement</th>
        <th>answers</th>
    </tr>
    <c:forEach items="${questions}" var="question">
        <tr>
            <td>${question.toughness}</td>
            <td>${question.problemStatement}</td>
            <td>
                <c:forEach items="${question.answers}" var="answer">
                    <input type="checkbox">${answer.text}
                    <br>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
