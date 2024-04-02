package edu.scoalainformala.homework9;
import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private char gender;
    private String CNP;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, char gender, String CNP) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.CNP = CNP;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public String getCNP() {
        return CNP;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dateOfBirth +
                ", gender=" + gender +
                ", id='" + CNP + '\'' +
                '}';
    }
}
