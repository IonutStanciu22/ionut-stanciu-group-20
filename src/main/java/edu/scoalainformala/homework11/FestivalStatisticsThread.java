package edu.scoalainformala.homework11;

import java.util.Queue;

class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000); // Every 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Queue<TicketType> ticketQueue = gate.getTicketQueue();
            int totalAttendees = ticketQueue.size();
            int fullCount = 0, fullVipCount = 0, freePassCount = 0, oneDayCount = 0, oneDayVipCount = 0;

            // Counting ticket types
            for (TicketType ticket : ticketQueue) {
                switch (ticket) {
                    case FULL:
                        fullCount++;
                        break;
                    case FULL_VIP:
                        fullVipCount++;
                        break;
                    case FREE_PASS:
                        freePassCount++;
                        break;
                    case ONE_DAY:
                        oneDayCount++;
                        break;
                    case ONE_DAY_VIP:
                        oneDayVipCount++;
                        break;
                }
            }

            // Printing statistics
            System.out.println("----- Festival Statistics -----");
            System.out.println(totalAttendees + " people entered");
            System.out.println(fullCount + " have full tickets");
            System.out.println(fullVipCount + " have full VIP passes");
            System.out.println(freePassCount + " have free passes");
            System.out.println(oneDayCount + " have one-day passes");
            System.out.println(oneDayVipCount + " have one-day VIP passes");
            System.out.println("-----------------------------");
        }
    }
}