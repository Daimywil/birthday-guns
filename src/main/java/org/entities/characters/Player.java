package org.entities.characters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

import org.entities.AliveEntity;
import org.entities.sprites.GunSprite;
import org.entities.sprites.PlayerSprite;
import org.guns.ApplepieGun;
import org.guns.Gun;
import org.maps.Tiles.Tile;
import org.scenes.GameScene;
import org.utilities.MouseUtilities;

public class Player extends AliveEntity implements KeyListener, Newtonian, UpdateExposer, Collider, Collided {
    private Gun gun;
    private boolean isWalking = false;
    private boolean isFiring = false;

    private GameScene gameScene;
    private PlayerSprite playerSprite = new PlayerSprite(new Coordinate2D(), this);
    private GunSprite gunSprite = new GunSprite("sprites/guns/applepie/gun.png", new Coordinate2D(), this);

    public Player(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation, 100, 200);
        gun = new ApplepieGun(gameScene);
        setFrictionConstant(0.1);
        setGravityConstant(0);
        setGravityDirection(0);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        int xSpeed = 0;
        int ySpeed = 0;

        //checkt toetsen en zet soort positie
        if (pressedKeys.contains(KeyCode.A)) {
            xSpeed = -1;
        }
        if (pressedKeys.contains(KeyCode.D)) {
            xSpeed = 1;
        }
        if (pressedKeys.contains(KeyCode.W)) {
            ySpeed = -1;
        }
        if (pressedKeys.contains(KeyCode.S)) {
            ySpeed = 1;
        }

        //maakt een hoek van die positie en zet de beweging in gang
        if (xSpeed != 0 || ySpeed != 0) {
            double direction = Math.toDegrees(Math.atan2(xSpeed, ySpeed)); //Berekend de richting
            isWalking = true;
            setMotion(3, direction);
        } else {
            isWalking = false;
        }
    }

    public boolean isWalking() {
        return isWalking;
    }

    public Coordinate2D getMouseAimDirection() {
        var mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        Point2D centerPosition = getAbsoluteCenterPosition();

        Point2D unitDirection = mousePosition.subtract(centerPosition).normalize();

        return new Coordinate2D(unitDirection.getX(), unitDirection.getY());
    }

    public Coordinate2D getAbsoluteCenterPosition() {
        int specificBugFixRandomOffset = 8;
        return this.playerSprite.getAbsolutePosition().add(new Coordinate2D(specificBugFixRandomOffset, 0));
    }

    public double getRotationRelativeToMousePosition() {
        Point2D unitDirection = getMouseAimDirection();

        double rotationDegrees = Math.toDegrees(Math.atan2(unitDirection.getX(), unitDirection.getY())) - 90;

        return rotationDegrees;
    }

    @Override
    public void explicitUpdate(long dt) {
        if (isFiring) {
            if (gun.canFire()) {
                shoot();
            }
        }
    }

    @Override
    protected void setupEntities() {
        addEntity(playerSprite);
        addEntity(gunSprite);
        // HealthBar healthBar = new HealthBar(this);
        // addEntity(healthBar);
        gunSprite.setViewOrder(2);
        // healthBar.setViewOrder(3);
    }

    private void shoot() {
        gun.fire(gunSprite.getGunTip(), getMouseAimDirection());
    }

    public void startFiring() {
        isFiring = true;
    }

    public void stopFiring() {
        isFiring = false;
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof Tile) {
                setSpeed(0);
                System.out.println("Blokkade aangeraakt!");
            } else if (collider instanceof Zombie) {
                System.out.println("Zombie aangeraakt!");
            }
        }
    }
}
