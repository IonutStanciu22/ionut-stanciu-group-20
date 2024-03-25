package edu.scoalainformala.stanciu_ionut_group_20.homework5;
import java.util.List;

public class Hobby {
    private final String name;
    private final int frequency;
    private final List<Address> addresses;

    public Hobby(String name, int frequency, List<Address> addresses) {
        this.name = name;
        this.frequency = frequency;
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
