package org.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.BirthdayGuns;
import org.entities.buttons.MapButton;
import org.entities.buttons.StartButton;
import org.entities.buttons.ButtonBackdrop;

public class HomeScene extends StaticScene {
    private BirthdayGuns birthdayGuns;

    public HomeScene (BirthdayGuns birthdayGuns) {
        this.birthdayGuns = birthdayGuns;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var startButton = new StartButton(new Coordinate2D(getWidth() * 0.5, getHeight() * 0.8), birthdayGuns);
        addEntity(startButton);
        var startButtonBackdrop = new ButtonBackdrop(new Coordinate2D(getWidth() * 0.5, getHeight() * 0.8), birthdayGuns);
        addEntity(startButtonBackdrop);

        var theBackyardButton = new MapButton("sprites/maps/icons/TheBackyardMap.png", new Coordinate2D(getWidth() * 0.3, getHeight() * 0.5), birthdayGuns, 0);
        addEntity(theBackyardButton);

        var theDungeonButton = new MapButton("sprites/maps/icons/TheDungeonMap.png", new Coordinate2D(getWidth() * 0.7, getHeight() * 0.5), birthdayGuns, 1);
        addEntity(theDungeonButton);
    }
}
