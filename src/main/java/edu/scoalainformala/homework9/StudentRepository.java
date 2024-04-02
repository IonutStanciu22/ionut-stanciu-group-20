package edu.scoalainformala.homework9;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StudentRepository {
    private List<Student> students;
    private Logger logger;

    public StudentRepository(Logger logger) {
        this.students = new ArrayList<>();
        this.logger = Logger.getLogger(StudentRepository.class.getName());
    }

    public void addStudent(String firstName, String lastName, LocalDate dob, char gender, String id) throws IllegalArgumentException {

        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("First name and last name cannot be empty");
        }
        if (gender != 'M' && gender != 'F') {
            throw new IllegalArgumentException("Gender should be 'M' or 'F'");
        }
        if (dob.isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("Student must be at least 18 years old");
        }


        Student student = new Student(firstName, lastName, dob, gender, id);
        students.add(student);
        logger.info("Student added: " + student.toString());
    }

    public void deleteStudent(String id) throws IllegalArgumentException {
        if (id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }

        boolean removed = students.removeIf(student -> student.getCNP().equals(id));
        if (!removed) {
            throw new IllegalArgumentException("Student with ID " + id + " does not exist");
        }
        logger.info("Student with ID " + id + " deleted");
    }

    public List<Student> retrieveStudentsWithAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        List<Student> studentsWithAge = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() == age) {
                studentsWithAge.add(student);
            }
        }
        return studentsWithAge;
    }

    public void listStudentsOrderedByLastName() throws IllegalArgumentException {
        if (students.isEmpty()) {
            throw new IllegalArgumentException("No students found");
        }

        students.sort((s1, s2) -> s1.getLastName().compareTo(s2.getLastName()));
        students.forEach(student -> logger.info(student.toString()));
    }

    public void listStudentsOrderedByBirthDate() throws IllegalArgumentException {
        if (students.isEmpty()) {
            throw new IllegalArgumentException("No students found");
        }

        students.sort((s1, s2) -> s1.getDateOfBirth().compareTo(s2.getDateOfBirth()));
        students.forEach(student -> logger.info(student.toString()));
    }
}
