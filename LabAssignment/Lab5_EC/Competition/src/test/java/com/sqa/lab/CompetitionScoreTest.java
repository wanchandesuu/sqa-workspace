package com.sqa.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.sqa.lab.CompetitionScore;

public class CompetitionScoreTest {

    private final CompetitionScore score = new CompetitionScore();

    @DisplayName("Test findMaxScore(score1, score2, score3)")
    @ParameterizedTest(name = "[{index}] ({0},{1},{2}) => {3}")
    @CsvSource({
        "100,200,300,300",
        "-1,200,300,INVALID",
        "100,-1,300,INVALID",
        "100,200,-1,INVALID",
        "501,200,300,INVALID",
        "100,501,300,INVALID",
        "100,200,501,INVALID",
        "-1,501,300,INVALID"
    })
    void testFindMaxScore(int score1, int score2, int score3, String expected) {

        try {
            int actual = score.findMaxScore(score1, score2, score3);
            assertEquals(expected, String.valueOf(actual));
        } catch (IllegalArgumentException e) {
            assertEquals(expected, "INVALID");
        }
    }

    @DisplayName("Test findMaxScore(int[] scores)")
    @ParameterizedTest(name = "[{index}] [{0},{1},{2}] => {3}")
    @CsvSource({
        "100,200,300,300",
        "-1,200,300,INVALID",
        "100,-1,301,INVALID",
        "100,200,-2,INVALID",
        "501,200,300,INVALID",
        "100,501,300,INVALID",
        "100,200,501,INVALID",
        "-1,501,300,INVALID"
    })
    void testFindMaxScoreArray(int s1, int s2, int s3, String expected) {

        int[] scores = {s1, s2, s3};

        try {
            int actual = score.findMaxScore(scores);
            assertEquals(expected, String.valueOf(actual));
        } catch (IllegalArgumentException e) {
            assertEquals(expected, "INVALID");
        }
    }
}
