package org.entities.sprites;

import java.util.List;

import org.maps.Tiles.CollidableTile;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import javafx.geometry.Bounds;

public abstract class CharacterSprite extends DynamicSpriteEntity implements UpdateExposer, Collided {
    public CharacterSprite(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(32, 32), 2, 4);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public Coordinate2D getAbsolutePosition() {
        return getLocationInScene();
    }

    protected abstract boolean isWalking();

    protected abstract boolean isWalkingLeft();

    protected abstract void onCollision(SceneBorder sceneBorder, CollidableTile collidableTile);

    @Override
    public void explicitUpdate(long dt) {
        boolean isWalking = isWalking();
        boolean isWalkingLeft = isWalkingLeft();

        if (isWalkingLeft) {
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

    private void handleCollision(SceneBorder sceneBorder, CollidableTile collidableTile) {
        onCollision(sceneBorder, collidableTile);
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (Collider collider : collidingObjects) {
            if (!(collider instanceof CollidableTile)) {
                continue;
            }
            CollidableTile collidableTile = (CollidableTile) collider;
            setSpeed(0);
            Bounds colliderBoundingBox = collider.getBoundingBox();
            Bounds spriteBoundingBox = getBoundingBox();

            int distanceFromTop = (int) Math.abs(colliderBoundingBox.getMinY() - spriteBoundingBox.getMaxY());
            int distanceFromBottom = (int) Math.abs(colliderBoundingBox.getMaxY() - spriteBoundingBox.getMinY());
            int distanceFromLeft = (int) Math.abs(colliderBoundingBox.getMinX() - spriteBoundingBox.getMaxX());
            int distanceFromRight = (int) Math.abs(colliderBoundingBox.getMaxX() - spriteBoundingBox.getMinX());

            int minDistance = Math.min(Math.min(distanceFromTop, distanceFromBottom), Math.min(distanceFromLeft, distanceFromRight));
            System.out.println(minDistance + " | " + distanceFromTop + " | " + distanceFromBottom + " | " + distanceFromLeft + " | " + distanceFromRight);
            if (minDistance == distanceFromTop) {
                handleCollision(SceneBorder.TOP, collidableTile);
            } else if (minDistance == distanceFromBottom) {
                handleCollision(SceneBorder.BOTTOM, collidableTile);
            } else if (minDistance == distanceFromLeft) {
                handleCollision(SceneBorder.LEFT, collidableTile);
            } else if (minDistance == distanceFromRight) {
                handleCollision(SceneBorder.RIGHT, collidableTile);
            }
            break;
        }
    }
}
