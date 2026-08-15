/*
 * A Driver for Bottom-up Integration Testing
 *
 * Test UniversalConverter
 */

public class Driver {

    /*
     * The entry point to the UniversalConverter class
     */

    public static void main(String[] args) {

        UniversalConverter converter =
                new UniversalConverter();

        // Distance
        double distanceResult =
                converter.convert(
                        5,
                        "Distance",
                        "kilometer",
                        "meter"
                );

        System.out.println(
                "Distance: 5 kilometer = "
                + distanceResult
                + " meter"
        );

        // Weight
        double weightResult =
                converter.convert(
                        2,
                        "Weight",
                        "kilogram",
                        "lbs"
                );

        System.out.println(
                "Weight: 2 kilogram = "
                + weightResult
                + " lbs"
        );

        // Temperature
        double temperatureResult =
                converter.convert(
                        25,
                        "Temperature",
                        "C",
                        "F"
                );

        System.out.println(
                "Temperature: 25 C = "
                + temperatureResult
                + " F"
        );
    }
}
