package org.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import com.github.hanyaeger.api.TimerContainer;

import javafx.geometry.Rectangle2D;
import javafx.scene.input.MouseButton;

import javafx.stage.Screen;

import java.util.Random;

import org.maps.Map;
import org.BirthdayGuns;
import org.entities.characters.PlayerCharacter;
import org.entities.characters.ZombieCharacter;
import org.entities.drop.GunDrop;
import org.entities.spawners.ZombieSpawner;
import org.guns.ApplepieGun;
import org.guns.Gun;
import org.guns.SoesjesGun;
import org.guns.WeddingCakeGun;
import org.maps.TheBackyardMap;
import org.maps.TheDungeonMap;
import org.projectiles.Projectile;
import org.statistics.GameStatistics;
import org.entities.timers.TimePlayedTimer;

public class GameScene extends DynamicScene implements TileMapContainer, MouseButtonPressedListener, MouseButtonReleasedListener, EntitySpawnerContainer, TimerContainer {
    private BirthdayGuns birthdayGuns;
    private Map map;
    private PlayerCharacter player;

    private GameStatistics gameStatistics = new GameStatistics();

    public static final int TILE_SIZE = 32;

    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    double screenWidth = screenBounds.getWidth();
    double screenHeight = screenBounds.getHeight();

    private final static int DROP_VIEW_ORDER = 1;
    private final static int ZOMBIE_VIEW_ORDER = 2;
    private final static int PLAYER_VIEW_ORDER = 3;
    private final static int PROJECTILE_VIEW_ORDER = 4;

    public static int mapNumber = 1;

    public GameScene (BirthdayGuns birthdayGuns) {
        this.birthdayGuns = birthdayGuns;
    }

    public GameStatistics getGameStatistics() {
        return gameStatistics;
    }

    public void addProjectile(Projectile projectile) {
        addEntity(projectile);
        projectile.setViewOrder(PROJECTILE_VIEW_ORDER);
    }

    public void onPlayerDeath() {
        birthdayGuns.endGame(gameStatistics);
    }

    public void onZombieDeath(ZombieCharacter zombie) {
        Gun gun = null;

        int randomGun = new Random().nextInt(3);
        switch (randomGun) {
            case 0:
                gun = new ApplepieGun(this);
                break;
            case 1:
                gun = new SoesjesGun(this);
                break;
            case 2:
                gun = new WeddingCakeGun(this);
                break;
        }
        if (gun == null) {
            return;
        }

        GunDrop gunDrop = new GunDrop(gun, zombie.getAnchorLocation());
        gunDrop.setViewOrder(DROP_VIEW_ORDER);
        addEntity(gunDrop);
    }

    @Override
    public void setupScene() {
    }

    public PlayerCharacter getPlayer() {
        return player;
    }

    @Override
    public void setupEntities() {
        if (mapNumber == 0) {
            map = new TheBackyardMap(this, new Coordinate2D(0, 0), new Size(TILE_SIZE * 30, TILE_SIZE * 30));
        } else if (mapNumber == 1) {
            map = new TheDungeonMap(this, new Coordinate2D(0, 0), new Size(TILE_SIZE * 30, TILE_SIZE * 30));
        }

        player = new PlayerCharacter(map.getSpawnLocation(), this);
        player.setViewOrder(PLAYER_VIEW_ORDER);
        addEntity(player);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(map);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new ZombieSpawner(this, ZOMBIE_VIEW_ORDER, map));
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
    public void setupTimers() {
        addTimer(new TimePlayedTimer(gameStatistics));
    }
}
