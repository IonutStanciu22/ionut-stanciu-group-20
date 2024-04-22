package edu.scoalainformala.homework11;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class FestivalGate {
    private final Queue<TicketType> ticketQueue;

    public FestivalGate() {
        this.ticketQueue = new ConcurrentLinkedQueue<>();
    }

    public void addTicket(TicketType ticketType) {
        ticketQueue.add(ticketType);
    }

    public Queue<TicketType> getTicketQueue() {
        return ticketQueue;
    }
}
