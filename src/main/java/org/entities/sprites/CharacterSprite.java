package org.entities.sprites;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class CharacterSprite extends DynamicSpriteEntity implements UpdateExposer {
    public CharacterSprite(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(64, 64), 2, 4);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public Coordinate2D getAbsolutePosition() {
        return getLocationInScene();
    }

    protected abstract boolean isWalking();

    protected abstract boolean isWalkingLeft();

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

}
