package org.entities.sprites.characters;

import org.entities.characters.ZombieCharacter;
import org.maps.tiles.CollidableTile;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.SceneBorder;

import javafx.geometry.Bounds;

public class ZombieSprite extends CharacterSprite {
    private final ZombieCharacter zombie;

    public ZombieSprite(Coordinate2D initialLocation, ZombieCharacter zombie) {
        super("sprites/characters/zombie.png", initialLocation);
        this.zombie = zombie;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    protected boolean isWalking() {
        return this.zombie.getSpeed() > 0;
    }

    @Override
    protected boolean isWalkingLeft() {
        return this.zombie.getDirection() <= 180;
    }

    @Override
    protected void onCollision(SceneBorder sceneBorder, CollidableTile collidableTile) {
        Bounds spriteBounds = getBoundingBox();
        Bounds tileBounds = collidableTile.getBoundingBox();
        zombie.setSpeed(0);
        switch (sceneBorder) {
            case BOTTOM:
                zombie.setAnchorLocationY(tileBounds.getMaxY() + spriteBounds.getHeight() / 2 + 1);
                break;
            case TOP:
                zombie.setAnchorLocationY(tileBounds.getMinY() - spriteBounds.getHeight() / 2 - 1);
                break;
            case LEFT:
                zombie.setAnchorLocationX(tileBounds.getMinX() - spriteBounds.getWidth() / 2 - 1);
                break;
            case RIGHT:
                zombie.setAnchorLocationX(tileBounds.getMaxX() + spriteBounds.getWidth() / 2 + 1);
                break;
        }
    }
}
