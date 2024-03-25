package edu.scoalainformala.homework6;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DistanceCalculator {

        public static int calculateDistance(String expression) {

            String pattern = "(\\d+)\\s*(mm|cm|dm|m|km)";
            Matcher matcher = Pattern.compile(pattern).matcher(expression);

            int totalDistance = 0;
            while (matcher.find()) {
                int value = Integer.parseInt(matcher.group(1));
                String unit = matcher.group(2);
                switch (unit) {
                    case "mm":
                        totalDistance += value;
                        break;
                    case "cm":
                        totalDistance += value * 10;
                        break;
                    case "dm":
                        totalDistance += value * 100;
                        break;
                    case "m":
                        totalDistance += value * 1000;
                        break;
                    case "km":
                        totalDistance += value * 1000000;
                        break;
                }
            }
            return totalDistance;
        }
}
