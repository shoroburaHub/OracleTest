/**
 * Created by admin on 1/13/2018.
 */
var counter = 0;
var questionSize = 0;
function init(num) {
    questionSize = num;
};
function comment(questionId) {
    var blockText = questionId + 'commentText';
    var newComment = document.getElementById(blockText).value;
    var oldComment = '';
    $.ajax({
        url: '/getComment/' + questionId,
        method: 'POST',
        success: function (res) {
            oldComment = res;
            if (oldComment != newComment) {
                saveComment(questionId, newComment);
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}
function saveComment(questionId, comment) {
    $.ajax({
        url: '/saveComment/' + questionId,
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(comment),
        success: function (res) {
            console.log(res);
        },
        error: function (err) {
            console.log(err);
        }
    });
}
function showComment(questionId) {
    var blockName = questionId + 'commentBlock';
    var blockText = questionId + 'commentText';
    $.ajax({
        url: '/getComment/' + questionId,
        method: 'POST',
        success: function (res) {
            document.getElementById(blockText).textContent = res;
        },
        error: function (err) {
            console.log(err);
        }
    });
    var hidden = document.getElementById(blockName).hidden;
    document.getElementById(blockName).hidden = hidden ? false : true;
}
function checkAnswer(questionId) {
    var checkboxes = document.getElementsByClassName(questionId + 'answers');
    var answerIds = new Array();
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked === true) {
            answerIds.push({id: checkboxes[i].value});
        }
    }
    $.ajax({
        url: '/checkAnswer/' + questionId,
        method: 'POST',
        success: function (res) {
            for (var i = 0; i < res.length; i++) {
                if (res[i].correct == true) {
                    document.getElementById(res[i].id).style.color = '#51ff00';
                } else {
                    document.getElementById(res[i].id).style.color = '#ff0029';
                }
            }
            countRightAnswers(answerIds, res);
            checkAnswer
            document.getElementById("checkAnswer" + questionId).disabled = true;
        },
        error: function (err) {
            console.log(err);
        }
    });
}
//scroll top function
scrollFunction();

function scrollFunction() {
    document.getElementById("myBtn").style.display = "block";
    document.getElementById("saveHistory").style.display = "block";
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}
function countRightAnswers(checkedAnswers, answers) {
    var correctAnswers = new Array();
    var checkedCorrectAnswers = new Array();

    for (var i = 0; i < answers.length; i++) {
        if (answers[i].correct === true) {
            correctAnswers.push(answers[i].id);
        }
    }
    for (var i = 0; i < checkedAnswers.length; i++) {
        var found = true;
        if (correctAnswers.includes(parseInt(checkedAnswers[i].id))) {
            checkedCorrectAnswers++;
            found = false;
        }
        if (found) {
            checkedCorrectAnswers--;
        }
    }
    if (correctAnswers.length == checkedCorrectAnswers && correctAnswers != 0) {
        counter++;
        document.getElementById("myBtn").innerHTML = '' + counter + ' / ' + questionSize;
    }
}
document.getElementById('saveHistory').onclick = function () {
    $.ajax({
        url: '/saveHistory/' + questionSize + '/' + counter,
        method: 'POST',
        error: function (err) {
            console.log(err);
        }
    });
}