package org.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener {
    public Player(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.A)) {
            setCurrentFrameIndex(0);
            setMotion(3, Direction.LEFT);
        } else if (pressedKeys.contains(KeyCode.D)) {
            setCurrentFrameIndex(1);
            setMotion(3, Direction.RIGHT);
        } else if (pressedKeys.contains(KeyCode.W)) {
            setMotion(3, Direction.UP);
        } else if (pressedKeys.contains(KeyCode.S)) {
            setMotion(3, Direction.DOWN);
        }
    }
}
