package com.oracle.test.entity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Created by admin on 1/14/2018.
 */
@Entity
public class TestHistory extends BaseEntity {

    private String testType;
    private LocalDateTime localDateTime;
    private String score;

    public TestHistory() {
    }

    public TestHistory(LocalDateTime localDateTime, String score) {
        this.localDateTime = localDateTime;
        this.score = score;
    }

    public TestHistory(String testType, LocalDateTime localDateTime, String score) {
        this.testType = testType;
        this.localDateTime = localDateTime;
        this.score = score;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "TestHistory{" +
                "testType='" + testType + '\'' +
                ", localDateTime=" + localDateTime +
                ", score='" + score + '\'' +
                '}';
    }
}
