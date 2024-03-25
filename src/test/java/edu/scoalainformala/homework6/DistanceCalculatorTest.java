package edu.scoalainformala.homework6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;



public class DistanceCalculatorTest {

    @Test

    public void testCalculateDistance() {
        String expression1 = "10 cm + 1 m - 10 mm";
        int expectedResult1 = 1110;
        int result1 = DistanceCalculator.calculateDistance(expression1);
        Assertions.assertEquals(expectedResult1, result1);

        String expression2 = "1 km - 500 m + 2 dm";
        int expectedResult2 = 1500200;
        int result2 = DistanceCalculator.calculateDistance(expression2);
        Assertions.assertEquals(expectedResult2, result2);

        String expression3 = "1000 mm + 10 m - 50 cm";
        int expectedResult3 = 11500;
        int result3 = DistanceCalculator.calculateDistance(expression3);
        Assertions.assertEquals(expectedResult3, result3);
    }
}
