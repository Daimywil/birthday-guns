package org.statistics;

public class GameStatistics {
    private double score = 0;
    private int kills = 0;
    private int timeAlive = 0;

    public void addScore(double score) {
        this.score = Math.max(0, this.score + score);
    }
    public double getScore() {
        return score;
    }

    public void addKill() {
        this.kills++;
    }
    public int getKills() {
        return kills;
    }

    public void addTimeAlive(int timePassed) {
        this.timeAlive = Math.max(0, this.timeAlive + timePassed);
    }
    public int getTimeAlive() {
        return timeAlive;
    }
}
