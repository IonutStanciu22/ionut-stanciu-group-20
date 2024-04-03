package edu.scoalainformala.homework8;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SkiBiathlonStandingsTest {

    @Test
    public void testParseCSV() {
        String csvData = """
            11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo
            1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo
            27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx""";

        List<Athlete> athletes = SkiBiathlonStandings.parseCSV(csvData);

        assertEquals(3, athletes.size());

        Athlete firstAthlete = athletes.get(0);
        assertEquals("Umar Jorgson", firstAthlete.getName());
        assertEquals("SK", firstAthlete.getCountryCode());
        assertEquals("30:27", firstAthlete.getSkiTime());
        assertEquals("xxxox", firstAthlete.getShootingRanges()[0]);
        assertEquals("xxxxx", firstAthlete.getShootingRanges()[1]);
        assertEquals("xxoxo", firstAthlete.getShootingRanges()[2]);

        Athlete secondAthlete = athletes.get(1);
        assertEquals("Jimmy Smiles", secondAthlete.getName());
        assertEquals("UK", secondAthlete.getCountryCode());
        assertEquals("29:15", secondAthlete.getSkiTime());
        assertEquals("xxoox", secondAthlete.getShootingRanges()[0]);
        assertEquals("xooxo", secondAthlete.getShootingRanges()[1]);
        assertEquals("xxxxo", secondAthlete.getShootingRanges()[2]);

        Athlete thirdAthlete = athletes.get(2);
        assertEquals("Piotr Smitzer", thirdAthlete.getName());
        assertEquals("CZ", thirdAthlete.getCountryCode());
        assertEquals("30:10", thirdAthlete.getSkiTime());
        assertEquals("xxxxx", thirdAthlete.getShootingRanges()[0]);
        assertEquals("xxxxx", thirdAthlete.getShootingRanges()[1]);
        assertEquals("xxxxx", thirdAthlete.getShootingRanges()[2]);
    }


    @Test
    public void testCalculateStandings() {

        Athlete athlete1 = new Athlete("Umar Jorgson", "SK", "30:27", new String[]{"xxxox", "xxxxx", "xxoxo"});
        Athlete athlete2 = new Athlete("Jimmy Smiles", "UK", "29:15", new String[]{"xxoox", "xooxo", "xxxxo"});
        Athlete athlete3 = new Athlete("Piotr Smitzer", "CZ", "30:10", new String[]{"xxxxx", "xxxxx", "xxxxx"});

        List<Athlete> athletes = List.of(athlete1, athlete2, athlete3);

        List<Athlete> standings = SkiBiathlonStandings.calculateStandings(athletes);


        assertEquals("Piotr Smitzer", standings.get(0).getName());
        assertEquals("Jimmy Smiles", standings.get(1).getName());
        assertEquals("Umar Jorgson", standings.get(2).getName());
    }
}