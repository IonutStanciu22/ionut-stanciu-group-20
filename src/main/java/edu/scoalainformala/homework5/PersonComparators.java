package edu.scoalainformala.homework5;

import java.util.Comparator;

public class PersonComparators {
    public static Comparator<Person> nameComparator = Comparator.comparing(Person::getName);
    public static Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);
}
