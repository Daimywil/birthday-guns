package org.entities.characters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

import java.util.Set;

import org.entities.Alive;
import org.entities.sprites.PlayerSprite;
import org.entities.sprites.guns.ApplepieGunSprite;
import org.entities.sprites.guns.GunSprite;
import org.entities.sprites.guns.SoesjesGunSprite;
import org.entities.sprites.guns.WeddingCakeGunSprite;
import org.guns.ApplepieGun;
import org.guns.Gun;
import org.guns.SoesjesGun;
import org.guns.WeddingCakeGun;
import org.scenes.GameScene;
import org.utilities.MouseUtilities;

public class PlayerCharacter extends Alive implements KeyListener, Newtonian, UpdateExposer, Collider {
    private Gun gun;
    private boolean isWalking = false;
    private boolean isFiring = false;

    private GameScene gameScene;
    private PlayerSprite playerSprite = new PlayerSprite(new Coordinate2D(), this);

    private GunSprite activeGunSprite;
    private GunSprite applepieGunSprite = new ApplepieGunSprite(new Coordinate2D(0, 0), this);
    private GunSprite soesjesGunSprite = new SoesjesGunSprite(getAnchorLocation(), this);
    private GunSprite weddingCakeGunSprite = new WeddingCakeGunSprite(getAnchorLocation(), this);


    public PlayerCharacter(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation, 100, 200);
        this.gameScene = gameScene;
        setGun(new ApplepieGun(gameScene));
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
        return this.playerSprite.getAbsolutePosition().add(new Coordinate2D(specificBugFixRandomOffset, 25));
    }

    public double getRotationRelativeToMousePosition() {
        Point2D unitDirection = getMouseAimDirection();

        double rotationDegrees = Math.toDegrees(Math.atan2(unitDirection.getX(), unitDirection.getY())) - 90;

        return rotationDegrees;
    }

    @Override
    public void onDeath() {
        gameScene.onPlayerDeath();
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
        addEntity(applepieGunSprite);
        addEntity(soesjesGunSprite);
        addEntity(weddingCakeGunSprite);
    }

    private void shoot() {
        gun.fire(activeGunSprite.getGunTip(), getMouseAimDirection());
    }

    public void startFiring() {
        isFiring = true;
    }

    public void stopFiring() {
        isFiring = false;
    }

    public void swapGun(Gun newGun) {
        setGun(newGun);
    }

    private void setGun(Gun gun) {
        this.gun = gun;
        applepieGunSprite.setOpacity(0);
        soesjesGunSprite.setOpacity(0);
        GunSprite gunSprite = null;
        if (gun instanceof ApplepieGun) {
            gunSprite = applepieGunSprite;
        } else if (gun instanceof SoesjesGun) {
            gunSprite = soesjesGunSprite;
        } else if (gun instanceof WeddingCakeGun) {
            gunSprite = weddingCakeGunSprite;
        }
        if (gunSprite == null) {
            return;
        }
        gunSprite.setOpacity(1);
        gunSprite.setViewOrder(2);
        activeGunSprite = gunSprite;
    }
}
