package edu.scoalainformala.homework10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java BirthdayFilter <input_filename> <target_month> <output_filename>");
            return;
        }

        String inputFilename = args[0];
        int targetMonth = Integer.parseInt(args[1]);
        String outputFilename = args[2];

        try {
            List<String> filteredNames = filterNamesByBirthday(inputFilename, targetMonth);
            writeToFile(filteredNames, outputFilename);
            System.out.println("Filtered names written to " + outputFilename);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static List<String> filterNamesByBirthday(String filename, int targetMonth) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            return br.lines()
                    .map(line -> line.split(","))
                    .filter(parts -> {
                        LocalDate birthDate = LocalDate.parse(parts[2], formatter);
                        return birthDate.getMonthValue() == targetMonth;
                    })
                    .map(parts -> parts[0] + " " + parts[1])
                    .sorted()
                    .collect(Collectors.toList());
        }
    }

    public static void writeToFile(List<String> names, String filename) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String name : names) {
                bw.write(name);
                bw.newLine();
            }
        }
    }
}
