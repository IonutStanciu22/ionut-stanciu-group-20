package edu.scoalainformala.homework5;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Address address1 = new Address("Dristor", "Bucuresti", "RO");
        Address address2 = new Address("Mihai Bravu", "Bucuresti", "RO");


        Hobby hobby1 = new Hobby("Cycling", 3, Arrays.asList(address1));
        Hobby hobby2 = new Hobby("Swimming", 2, Arrays.asList(address1, address2));


        Person person1 = new Person("Andrei", 30);
        Person person2 = new Person("Bogdan", 25);


        Map<Person, List<Hobby>> personHobbiesMap = new HashMap<>();
        personHobbiesMap.put(person1, Arrays.asList(hobby1, hobby2));
        personHobbiesMap.put(person2, Arrays.asList(hobby2));


        Set<Person> treeSetByName = new TreeSet<>(PersonComparators.nameComparator);
        treeSetByName.add(person1);
        treeSetByName.add(person2);


        for (Person person : treeSetByName) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }


        System.out.println("Hobbies for " + person1.getName() + ":");
        List<Hobby> hobbies = personHobbiesMap.get(person1);
        if (hobbies != null) {
            for (Hobby hobby : hobbies) {
                System.out.println("Hobby: " + hobby.getName());
                System.out.println("Can be practiced in:");
                for (Address address : hobby.getAddresses()) {
                    System.out.println(address.getCountry());
                }
            }
        } else {
            System.out.println("No hobbies found for " + person1.getName());
        }
    }
}
