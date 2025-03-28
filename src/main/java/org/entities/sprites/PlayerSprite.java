package org.entities.sprites;

import org.entities.characters.Player;
import org.utilities.MouseUtilities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;

public class PlayerSprite extends CharacterSprite {
    private final Player player;

    public PlayerSprite(Coordinate2D initialLocation, Player player) {
        super("sprites/characters/zombie.png", initialLocation);
        this.player = player;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public Coordinate2D getAbsolutePosition() {
        return getLocationInScene();
    }

    @Override
    public void explicitUpdate(long dt) {
        Coordinate2D mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        Double centerPlayerXPos = this.player.getAbsoluteCenterPosition().getX();

        if (centerPlayerXPos <= mousePosition.getX()) {
            if (player.isWalking) {
                setAutoCycle(100, 0);
            } else {
                setCurrentFrameIndex(0);
            }
        } else {
            if (player.isWalking) {
                setAutoCycle(100, 1);
            } else {
                setCurrentFrameIndex(4);
            }
        }
    }

    @Override
    protected boolean isWalking() {
        return player.isWalking;
    }

    @Override
    protected boolean isWalkingLeft() {
        Coordinate2D mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        Double centerPlayerXPos = this.player.getAbsoluteCenterPosition().getX();

        return centerPlayerXPos <= mousePosition.getX();
    }

}
