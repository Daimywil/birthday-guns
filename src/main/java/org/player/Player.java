package org.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.awt.*;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, Newtonian {
    public Player(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(64, 128), 4, 2);

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
            setMotion(3, direction);
        }
    }

    public void flipPlayer() {
        Point mousePos = MouseInfo.getPointerInfo().getLocation();
        int mouseXPos = mousePos.x;
        int playerXPos = (int) this.getAnchorLocation().getX();

        if (playerXPos <= mouseXPos) {
            setCurrentFrameIndex(0);
        } else {
            setCurrentFrameIndex(1);
        }
    }
}
