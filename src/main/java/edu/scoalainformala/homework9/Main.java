package edu.scoalainformala.homework9;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class.getName());


        StudentRepository repository = new StudentRepository(logger);


        try {
            repository.addStudent("Ionut", "Pop", LocalDate.of(1995, 5, 15), 'M', "1234567890123");
            repository.addStudent("Andrei", "Stefan", LocalDate.of(2000, 8, 25), 'F', "9876543210987");
            repository.addStudent("Alice", "Popescu", LocalDate.of(2005, 9, 10), 'F', "1234567890123"); // Test invalid last name
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Error adding student: " + e.getMessage());
        }


        try {
            logger.info("Students ordered by last name:");
            repository.listStudentsOrderedByLastName();
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Error listing students: " + e.getMessage());
        }


        try {
            logger.info("Students with age 25:");
            repository.retrieveStudentsWithAge(25).forEach(student -> logger.info(student.toString()));
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Error retrieving students with age 25: " + e.getMessage());
        }


        try {
            repository.deleteStudent("1234567890123");
            logger.info("After deleting student with ID 1234567890123:");
            repository.listStudentsOrderedByLastName();
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Error deleting student: " + e.getMessage());
        }

        int invalidAge = -5;
        try {
            logger.info("Students with age " + invalidAge + ":");
            repository.retrieveStudentsWithAge(invalidAge).forEach(student -> logger.info(student.toString()));
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Error retrieving students with age " + invalidAge + ": " + e.getMessage());
        }
    }

}
