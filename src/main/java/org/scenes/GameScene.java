package org.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.BirthdayGuns;
import org.player.Player;

public class GameScene extends DynamicScene {
    private BirthdayGuns birthdayGuns;

    public GameScene (BirthdayGuns birthdayGuns) {
        this.birthdayGuns = birthdayGuns;
    }

    @Override
    public void setupScene() {
        addEntity(new Player("sprites/PlayerSprite.png", new Coordinate2D(getWidth() / 2, getHeight() / 2)));
    }

    @Override
    public void setupEntities() {

    }
}
