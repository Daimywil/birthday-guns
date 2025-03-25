package org.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.BirthdayGuns;
import org.entities.buttons.StartButton;

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
        addEntity(new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2), birthdayGuns));
    }
}
