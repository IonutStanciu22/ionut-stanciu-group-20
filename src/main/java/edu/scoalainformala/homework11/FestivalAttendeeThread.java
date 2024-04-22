package edu.scoalainformala.homework11;

import java.util.Random;

class FestivalAttendeeThread extends Thread {
    private final FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.gate = gate;
        gate.addTicket(ticketType);
    }

    @Override
    public void run() {
        // Simulating attendee entering festival and adding ticket to gate
        try {
            Thread.sleep(new Random().nextInt(1000)); // Simulating time to enter
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}