package org.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;

import javafx.geometry.Rectangle2D;
import javafx.scene.input.MouseButton;

import javafx.scene.paint.Color;
import javafx.stage.Screen;
import org.BirthdayGuns;
import org.entities.characters.Player;
import org.entities.spawners.ZombieSpawner;
import org.maps.TheBackyardMap;
import org.projectiles.Projectile;

public class GameScene extends ScrollableDynamicScene implements TileMapContainer, MouseButtonPressedListener, MouseButtonReleasedListener, EntitySpawnerContainer, UpdateExposer {
    private BirthdayGuns birthdayGuns;
    private Player player;

    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    double screenWidth = screenBounds.getWidth();
    double screenHeight = screenBounds.getHeight();

    public GameScene (BirthdayGuns birthdayGuns) {
        this.birthdayGuns = birthdayGuns;
    }

    public void addProjectile(Projectile projectile) {
        addEntity(projectile);
    }

    @Override
    public void setupScene() {
        player = new Player(new Coordinate2D(getWidth() / 2, getHeight() / 2), this);
        setBackgroundColor(Color.rgb(95, 178, 53));
        addEntity(player);
        setRelativeScrollPosition(0.5, 0.5);
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void setupEntities() {

    }

    @Override
    public void setupTileMaps() {
        TheBackyardMap map = new TheBackyardMap(this, new Coordinate2D(0, 0), new Size(32 * 30, 32 * 30));
        addTileMap(map);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new ZombieSpawner(this));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
        player.startFiring();
    }

    @Override
    public void onMouseButtonReleased(MouseButton button, Coordinate2D coordinate2d) {
        player.stopFiring();
    }

    @Override
    public void explicitUpdate(final long timestamp) {
        var spaceShipLocation = player.getAnchorLocation();
        setScrollPosition(spaceShipLocation);
    }
}
