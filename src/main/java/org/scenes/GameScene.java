package org.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;

import javafx.scene.input.MouseButton;

import org.BirthdayGuns;
import org.entities.Player;
import org.maps.TheBackyardMap;
import org.projectiles.Projectile;

public class GameScene extends DynamicScene implements TileMapContainer, MouseButtonReleasedListener {
    private BirthdayGuns birthdayGuns;
    private Player player;

    public GameScene (BirthdayGuns birthdayGuns) {
        this.birthdayGuns = birthdayGuns;
    }

    public void addProjectile(Projectile projectile) {
        addEntity(projectile);
    }

    @Override
    public void setupScene() {
        player = new Player(new Coordinate2D(getWidth() / 2, getHeight() / 2), this);
        addEntity(player);
    }

    @Override
    public void setupEntities() {

    }

    @Override
    public void setupTileMaps() {
        new TheBackyardMap(this);
    }

    @Override
    public void onMouseButtonReleased(MouseButton button, Coordinate2D coordinate2d) {
        player.shoot(button, coordinate2d);
    }
}
