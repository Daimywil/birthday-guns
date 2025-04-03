package org;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.maps.Map;
import org.maps.TheBackyardMap;
import org.scenes.GameScene;
import org.scenes.HomeScene;
import org.scenes.ScoreScene;
import org.statistics.GameStatistics;

import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

public class BirthdayGuns extends YaegerGame {
    private GameStatistics gameStatistics;

    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    double screenWidth = screenBounds.getWidth();
    double screenHeight = screenBounds.getHeight();

    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Birthday Guns");
        // setSize(new Size(screenWidth, screenHeight));
        setSize(new Size(1000, 1000));
    }

    public void endGame(GameStatistics gameStatistics) {
        this.gameStatistics = gameStatistics;
        setActiveScene(2);
    }

    public GameStatistics getGameStatistics() {
        return gameStatistics;
    }

    @Override
    public void setupScenes() {
        addScene(0, new HomeScene(this));
        addScene(1, new GameScene(this));
        addScene(2, new ScoreScene(this));
    }
}