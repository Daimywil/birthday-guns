package org.entities.timers;

import org.statistics.GameStatistics;

import com.github.hanyaeger.api.Timer;

public class TimePlayedTimer extends Timer {
    private GameStatistics gameStatistics;

    public TimePlayedTimer(GameStatistics gameStatistics) {
        super(1000);
        this.gameStatistics = gameStatistics;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        gameStatistics.addTimeAlive(1);
    }

}
