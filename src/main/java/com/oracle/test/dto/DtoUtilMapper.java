package com.oracle.test.dto;

import com.oracle.test.entity.Answer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by admin on 1/1/2018.
 */
public class DtoUtilMapper {
    public static AnswerDto answerToAnswerDto(Answer answer) {
        return new AnswerDto(answer.getId(), answer.isCorrect());
    }
    public static List<AnswerDto> answersToAnswerDtos(List<Answer> answers) {
        return answers.stream().map(e -> new AnswerDto(e.getId(), e.isCorrect())).collect(Collectors.toList());
    }
}
