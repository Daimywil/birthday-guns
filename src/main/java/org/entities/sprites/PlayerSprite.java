package org.entities.sprites;

import org.utilities.MouseUtilities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PlayerSprite extends DynamicSpriteEntity implements UpdateExposer {
    public PlayerSprite(Coordinate2D initialLocation) {
        super("sprites/PlayerSprite.png", initialLocation, new Size(64, 128), 4, 2);
    }

    @Override
    public void explicitUpdate(long dt) {
        var mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        int centerPlayerXPos = (int) (this.getAnchorLocation().getX() + this.getWidth() / 2);

        if (centerPlayerXPos <= mousePosition.getX()) {
            setCurrentFrameIndex(0);
        } else {
            setCurrentFrameIndex(5);
        }
    }

}
