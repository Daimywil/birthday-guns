package org.entities.sprites;

import org.entities.characters.Player;
import org.utilities.MouseUtilities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;

public class PlayerSprite extends CharacterSprite {
    private final Player player;

    public PlayerSprite(Coordinate2D initialLocation, Player player) {
        super("sprites/characters/player.png", initialLocation);
        this.player = player;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void explicitUpdate(long dt) {
        Coordinate2D mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        Double centerPlayerXPos = this.player.getAbsoluteCenterPosition().getX();

        boolean isWalking = player.isWalking();

        if (centerPlayerXPos <= mousePosition.getX()) {
            if (isWalking) {
                setAutoCycle(100, 0);
            } else {
                setCurrentFrameIndex(0);
            }
        } else {
            if (isWalking) {
                setAutoCycle(100, 1);
            } else {
                setCurrentFrameIndex(4);
            }
        }
    }

    @Override
    protected boolean isWalking() {
        return player.isWalking();
    }

    @Override
    protected boolean isWalkingLeft() {
        Coordinate2D mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        Double centerPlayerXPos = this.player.getAbsoluteCenterPosition().getX();

        return centerPlayerXPos <= mousePosition.getX();
    }

}
