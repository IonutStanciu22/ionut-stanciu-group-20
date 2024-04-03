package edu.scoalainformala.homework8;

public class Athlete implements Comparable<Athlete> {

    private final String name;
    private final String countryCode;
    private final String skiTime;
    private final int[] shootingPenalties;

    public Athlete(String name, String countryCode, String skiTime, String[] shootingRanges) {
        this.name = name;
        this.countryCode = countryCode;
        this.skiTime = skiTime;
        this.shootingPenalties = calculateShootingPenalties(shootingRanges);
    }

    public String getName() {
        return name;
    }

    public String getSkiTime() {
        return skiTime;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getTotalTime() {
        int totalTime = timeStringToSeconds(skiTime);
        for (int penalty : shootingPenalties) {
            totalTime += penalty;
        }
        return totalTime;
    }

    public int[] getShootingPenalties() {
        return shootingPenalties;
    }

    private int timeStringToSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    private int[] calculateShootingPenalties(String[] shootingRanges) {
        int[] penalties = new int[shootingRanges.length];
        for (int i = 0; i < shootingRanges.length; i++) {
            String range = shootingRanges[i];
            int penalty = 0;
            for (char shot : range.toCharArray()) {
                if (shot == ShootingResult.MISS.symbol) {
                    penalty += ShootingResult.MISS.getPenalty();
                }
            }
            penalties[i] = penalty;
        }
        return penalties;
    }

    @Override
    public int compareTo(Athlete other) {
        return Integer.compare(getTotalTime(), other.getTotalTime());
    }

    public Object[] getShootingRanges() {
        return new Object[0];
    }
}