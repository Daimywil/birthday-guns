package org.entities.sprites;

import org.entities.characters.PlayerCharacter;
import org.maps.Tiles.CollidableTile;
import org.utilities.MouseUtilities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.SceneBorder;

import javafx.geometry.Bounds;

public class PlayerSprite extends CharacterSprite {
    private final PlayerCharacter player;

    public PlayerSprite(Coordinate2D initialLocation, PlayerCharacter player) {
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

    @Override
    protected void onCollision(SceneBorder sceneBorder, CollidableTile collidableTile) {
        Bounds spriteBounds = getBoundingBox();
        Bounds tileBounds = collidableTile.getBoundingBox();
        player.setSpeed(0);
        switch (sceneBorder) {
            case BOTTOM:
                player.setAnchorLocationY(tileBounds.getMaxY() + spriteBounds.getHeight() / 2 + 1);
                break;
            case TOP:
                player.setAnchorLocationY(tileBounds.getMinY() - spriteBounds.getHeight() / 2 - 1);
                break;
            case LEFT:
                player.setAnchorLocationX(tileBounds.getMinX() - spriteBounds.getWidth() / 2 - 1);
                break;
            case RIGHT:
                player.setAnchorLocationX(tileBounds.getMaxX() + spriteBounds.getWidth() / 2 + 1);
                break;
        }
    }
}
