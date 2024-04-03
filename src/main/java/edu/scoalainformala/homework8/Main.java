package edu.scoalainformala.homework8;

import java.util.List;

import static edu.scoalainformala.homework8.SkiBiathlonStandings.calculateStandings;
import static edu.scoalainformala.homework8.SkiBiathlonStandings.parseCSV;


public class Main {


    public static void main(String[] args) {

        String csvData = """
                11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo
                1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo
                27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx""";
        List<Athlete> athletes = parseCSV(csvData);


        List<Athlete> standings = calculateStandings(athletes);


        System.out.println("Winner - " + standings.get(0).getName() + " " + standings.get(0).getSkiTime());
        System.out.println("Runner-up - " + standings.get(1).getName() + " " + standings.get(1).getSkiTime());
        System.out.println("Third Place - " + standings.get(2).getName() + " " + standings.get(2).getSkiTime());
    }

    private List<Athlete> athletes;
    List<Athlete> standings = calculateStandings(athletes);

    {


        System.out.println("Winner - " + standings.get(0).getName() + " " + standings.get(0).getSkiTime());
        System.out.println("Runner-up - " + standings.get(1).getName() + " " + standings.get(1).getSkiTime());
        System.out.println("Third Place - " + standings.get(2).getName() + " " + standings.get(2).getSkiTime());

    }
}