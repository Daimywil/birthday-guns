package org.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;

import javafx.scene.input.MouseButton;

import org.BirthdayGuns;
import org.entities.characters.Player;
import org.entities.spawners.ZombieSpawner;
import org.maps.TheBackyardMap;
import org.projectiles.Projectile;

public class GameScene extends DynamicScene implements TileMapContainer, MouseButtonReleasedListener, EntitySpawnerContainer {
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

    public Player getPlayer() {
        return player;
    }

    @Override
    public void setupEntities() {

    }

    @Override
    public void setupTileMaps() {
        System.out.println("👉 setupTileMaps() wordt aangeroepen!");
        TheBackyardMap map = new TheBackyardMap(this);
        addTileMap(map);
        System.out.println("✅ Tilemap toegevoegd: " + map);
    }

    @Override
    public void onMouseButtonReleased(MouseButton button, Coordinate2D coordinate2d) {
        player.shoot(button, coordinate2d);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new ZombieSpawner(this));
    }
}
