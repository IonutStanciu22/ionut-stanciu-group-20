package edu.scoalainformala.homework11;

import java.util.Random;

public class Festival {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();


        for (int i = 0; i < 100; i++) {
            TicketType ticketType = TicketType.values()[new Random().nextInt(TicketType.values().length)];
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, gate);
            attendee.start();

        }
    }
}