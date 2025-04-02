package org.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;

import javafx.geometry.Rectangle2D;
import javafx.scene.input.MouseButton;

import javafx.scene.paint.Color;
import javafx.stage.Screen;

import java.util.Random;

import org.BirthdayGuns;
import org.entities.characters.Player;
import org.entities.characters.Zombie;
import org.entities.drop.GunDrop;
import org.entities.spawners.ZombieSpawner;
import org.guns.ApplepieGun;
import org.guns.Gun;
import org.guns.SoesjesGun;
import org.maps.TheBackyardMap;
import org.projectiles.Projectile;

public class GameScene extends DynamicScene implements TileMapContainer, MouseButtonPressedListener, MouseButtonReleasedListener, EntitySpawnerContainer {
    private BirthdayGuns birthdayGuns;
    private Player player;

    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    double screenWidth = screenBounds.getWidth();
    double screenHeight = screenBounds.getHeight();

    private final static int DROP_VIEW_ORDER = 1;
    private final static int ZOMBIE_VIEW_ORDER = 2;
    private final static int PLAYER_VIEW_ORDER = 3;
    private final static int PROJECTILE_VIEW_ORDER = 4;

    public GameScene (BirthdayGuns birthdayGuns) {
        this.birthdayGuns = birthdayGuns;
    }

    public void addProjectile(Projectile projectile) {
        addEntity(projectile);
        projectile.setViewOrder(PROJECTILE_VIEW_ORDER);
    }

    public void onZombieDeath(Zombie zombie) {
        Gun gun = null;

        int randomGun = new Random().nextInt(2);
        switch (randomGun) {
            case 0:
                gun = new ApplepieGun(this);
                break;
            case 1:
                gun = new SoesjesGun(this);
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
        player = new Player(new Coordinate2D(400, 400), this);
        player.setViewOrder(PLAYER_VIEW_ORDER);
        setBackgroundColor(Color.rgb(95, 178, 53));
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
        TheBackyardMap map = new TheBackyardMap(this, new Coordinate2D(0, 0), new Size(32 * 30, 32 * 30));
        addTileMap(map);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new ZombieSpawner(this, ZOMBIE_VIEW_ORDER));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
        player.startFiring();
    }

    @Override
    public void onMouseButtonReleased(MouseButton button, Coordinate2D coordinate2d) {
        player.stopFiring();
    }
}
