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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body onload="init(${questions.size()})">
<div class="context">
    <table class="table table-hover">
        <h3 class="cent">${subCategory.name} ${questions.size()}</h3>
        <tr>
            <th>toughness</th>
            <th>problemStatement</th>
        </tr>
        <c:forEach items="${questions}" var="question">
            <tr>
                <td>${question.toughness}</td>
                <td>${question.problemStatement}
                    <c:forEach items="${question.answers}" var="answer">
                        <p id="${answer.id}"><input class="${question.id}answers" type="checkbox"
                                                    value="${answer.id}"> ${answer.text}</p>
                    </c:forEach>
                    <br>
                    <div id="${question.id}commentBlock" hidden="true">
                        <textarea id="${question.id}commentText" style="width: 80%; height: 200px;"></textarea>
                        <br>
                        <button class="btn btn-primary" onclick="comment(${question.id})">save comment</button>
                    </div>
                    <br>
                    <button id="checkAnswer${question.id}" class="btn btn-primary" onclick="checkAnswer(${question.id})">check</button>
                    <button class="btn btn-primary" onclick="showComment(${question.id})">comment</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="topFunction()" id="myBtn">0 / ${questions.size()}</button>
    <button onclick="topFunction()" id="saveHistory">save history</button>
</div>
<script src="/js/main.js"></script>
</body>
</html>