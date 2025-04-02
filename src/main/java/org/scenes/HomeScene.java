package org.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.BirthdayGuns;
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
    }
}
