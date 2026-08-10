package test.java.sqa.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import main.java.sqa.lab.QuadraticEquation;


public class EEDT {
    QuadraticEquation quadraticEquation = new QuadraticEquation();

    @ParameterizedTest
    @CsvFileSource(
        files = "src/test/resources/EEDT.csv",
        numLinesToSkip = 1
    )
    @DisplayName("EEDT")
    void TestLEDT(int a, int b, int c, String result){
        assertEquals(quadraticEquation.determineRootNature(a, b, c).toString(), result);
    }
}
