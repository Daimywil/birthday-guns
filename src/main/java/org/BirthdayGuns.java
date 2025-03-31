package org;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.scenes.GameScene;
import org.scenes.HomeScene;
import org.scenes.ScoreScene;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

public class BirthdayGuns extends YaegerGame {

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
        setSize(new Size(screenWidth, screenHeight));
    }

    @Override
    public void setupScenes() {
        addScene(0, new HomeScene(this));
        addScene(1, new GameScene(this));
        addScene(2, new ScoreScene(this));
    }
}