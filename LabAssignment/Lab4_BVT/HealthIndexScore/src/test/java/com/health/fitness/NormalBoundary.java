package com.health.fitness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class NormalBoundary {

    @ParameterizedTest
    @CsvFileSource(
        files = "src/test/resources/Normal.csv",
        numLinesToSkip = 1
    )
    @DisplayName("Normal Boundary Value Testing")
    void testNormalBoundaryValue(
            double vo2Max,
            int rhr,
            int hrr,
            String expectedResult) {

        if ("INVALID".equals(expectedResult)) {

            assertThrows(
                IllegalArgumentException.class,
                () -> new HealthIndexScore(vo2Max, rhr, hrr)
            );

        } else {

            HealthIndexScore health =
                    new HealthIndexScore(vo2Max, rhr, hrr);

            assertEquals(
                HealthIndexScore.FitnessLevel.valueOf(expectedResult),
                health.getFitnessLevel()
            );
        }
    }
}
