package edu.scoalainformala.stanciu_ionut_group_20.homework4;

public class Call {
    private final String receiver;
    private int duration;

    public Call(String receiver) {
        this.receiver = receiver;
    }


    public String getReceiver() {
        return receiver;
    }

    public int getDuration() {
        return duration;
    }

}