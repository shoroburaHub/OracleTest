package com.oracle.test.dto;

/**
 * Created by admin on 1/1/2018.
 */
public class AnswerDto {
    private Long id;
    private boolean correct;

    public AnswerDto() {
    }

    public AnswerDto(Long id, boolean correct) {
        this.id = id;
        this.correct = correct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
