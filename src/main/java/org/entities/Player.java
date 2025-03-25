package org.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.util.Set;

import org.entities.sprites.GunSprite;
import org.entities.sprites.PlayerSprite;
import org.guns.Gun;
import org.guns.SoesjesGun;
import org.scenes.GameScene;
import org.utilities.MouseUtilities;

public class Player extends AliveEntity implements KeyListener, Newtonian, UpdateExposer {
    public Gun gun;
    public boolean isWalking = false;

    private GameScene gameScene;
    private PlayerSprite playerSprite = new PlayerSprite(new Coordinate2D(), this);
    private GunSprite gunSprite = new GunSprite(new Coordinate2D());

    public Player(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation, 100);
        gun = new SoesjesGun(gameScene);
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

    public Coordinate2D getMouseUnitDirection() {
        var mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        Point2D centerPlayerPosition = this.getLocationInScene().add(getWidth() / 2, getHeight() / 2);

        Point2D unitDirection = mousePosition.subtract(centerPlayerPosition).normalize();

        return new Coordinate2D(unitDirection.getX(), unitDirection.getY());
    }

    public double getRotationRelativeToMousePosition() {
        Point2D unitDirection = getMouseUnitDirection();

        double rotationDegrees = Math.toDegrees(Math.atan2(unitDirection.getX(), unitDirection.getY())) - 90;

        return rotationDegrees;
    }

    @Override
    public void explicitUpdate(long dt) {

    }

    @Override
    protected void setupEntities() {
        addEntity(playerSprite);
        addEntity(gunSprite);
        gunSprite.setViewOrder(2);
        gunSprite.setAnchorLocationY(20);
        gunSprite.setAnchorLocationX(40);
    }

    public void shoot(MouseButton button, Coordinate2D coordinate2d) {
        gun.fire(getLocationInScene(), getMouseUnitDirection());
    }
}
