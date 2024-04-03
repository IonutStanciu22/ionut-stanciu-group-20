
package edu.scoalainformala.homework8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

public class SkiBiathlonStandings {

    public static List<Athlete> parseCSV(String csvData) {
        List<Athlete> athletes = new ArrayList<>();
        String[] lines = csvData.split("\n");
        for (String line : lines) {
            String[] parts = line.split(",");
            String name = parts[1];
            String countryCode = parts[2];
            String skiTime = parts[3];
            String[] shootingRanges = Arrays.copyOfRange(parts, 4, parts.length);
            athletes.add(new Athlete(name, countryCode, skiTime, shootingRanges));
        }
        return athletes;
    }

    public static List<Athlete> calculateStandings(List<Athlete> athletes) {
        List<Athlete> sortedAthletes = new ArrayList<>(athletes);
        sortedAthletes.sort(Comparator.naturalOrder());
        return sortedAthletes;
    }
}