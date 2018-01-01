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


    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<div class="container">
    <table class="table table-hover">
        <h3>${subCategory.name} ${questions.size()}</h3>
        <tr>
            <th>toughness</th>
            <th>problemStatement</th>
        </tr>
        <c:forEach items="${questions}" var="question">
            <tr>
                <td>${question.toughness}</td>
                <td>${question.problemStatement}
                    <c:forEach items="${question.answers}" var="answer">
                        <p id="${answer.id}"><input type="checkbox" value="${answer.id}"> ${answer.text}</p>
                    </c:forEach>
                    <br>
                    <button class="btn btn-primary" onclick="checkAnswer(${question.id})">check</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
    function checkAnswer(questionId) {
//        console.log('questionId = ' + questionId);
//        var checkboxes = document.getElementsByClassName(questionId);
//        var answerIds = new Array();
//        for (var i = 0; i < checkboxes.length; i++) {
//            if (checkboxes[i].checked === true) {
//                answerIds.push(checkboxes[i].value);
//            }
//        }
//        console.log(answerIds);
        $.ajax({
            url: '/checkAnswer/' + questionId,
            method: 'POST',
            success: function (res) {
                console.log(res);
                for (var i = 0; i < res.length; i++) {
                    if(res[i].correct == true){
                        document.getElementById(res[i].id).style.color = '#51ff00';
                    }else {
                        document.getElementById(res[i].id).style.color = '#ff0029';
                    }
                }
            },
            error: function (err) {
                console.log(err);
            }
        })
    }
</script>
</body>
</html>