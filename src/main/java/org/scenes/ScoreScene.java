package org.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.BirthdayGuns;
import org.entities.buttons.*;
import org.statistics.GameStatistics;

public class ScoreScene extends StaticScene {
    private BirthdayGuns birthdayGuns;

    public ScoreScene (BirthdayGuns birthdayGuns) {
        this.birthdayGuns = birthdayGuns;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextLabel(new Coordinate2D(getWidth() * 0.5, getHeight() * 0.5), birthdayGuns);
        gameOverText.setText("Game Over!");
        addEntity(gameOverText);

        var retryButton = new RetryButton(new Coordinate2D(getWidth() * 0.5, getHeight() * 0.8), birthdayGuns);
        addEntity(retryButton);
        var retryButtonBackdrop = new ButtonBackdrop(new Coordinate2D(getWidth() * 0.5, getHeight() * 0.8), birthdayGuns);
        addEntity(retryButtonBackdrop);

        GameStatistics gameStatistics = birthdayGuns.getGameStatistics();

        var scoreText = new TextLabel(new Coordinate2D(getWidth() * 0.5, getHeight() * 0.1), birthdayGuns);
        double score = gameStatistics.getScore();
        double kills = gameStatistics.getKills();
        double time = gameStatistics.getTimeAlive();

        scoreText.setText("SCORE: " + score + "\n" + "KILLS: " + kills + "\n" + "TIME: " + time);
        addEntity(scoreText);

    }
}
