import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * Top-down Integration Testing
 * Test using Stubs
 */

class TestWithStub {

    @Test
    void testDistanceStub_5km_to_5000m() {

        DistanceStub stub = new DistanceStub();

        double expectedResult = 25000.0;

        assertEquals(
                expectedResult,
                stub.convert(
                        5,
                        "kilometer",
                        "meter"
                )
        );
    }

    @Test
    void testWeightStub_2kg_to_4410lbs() {

        WeightStub stub = new WeightStub();

        double expectedResult = 8.82;

        assertEquals(
                expectedResult,
                stub.convert(
                        2,
                        "kilogram",
                        "lbs"
                )
        );
    }

    @Test
    void testTemperatureStub_25C_to_57F() {

        TemperatureStub stub =
                new TemperatureStub();

        double expectedResult = 57.0;

        assertEquals(
                expectedResult,
                stub.convert(
                        25,
                        "C",
                        "F"
                )
        );
    }
}
