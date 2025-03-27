package org;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.scenes.GameScene;
import org.scenes.HomeScene;
import org.scenes.ScoreScene;

public class BirthdayGuns extends YaegerGame
{
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Birthday Guns");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new HomeScene(this));
        addScene(1, new GameScene(this));
        addScene(2, new ScoreScene(this));
    }
}