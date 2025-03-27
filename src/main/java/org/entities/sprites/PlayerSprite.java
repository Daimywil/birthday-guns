package org.entities.sprites;

import org.entities.Player;
import org.utilities.MouseUtilities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PlayerSprite extends DynamicSpriteEntity implements UpdateExposer {
    private final Player player;

    public PlayerSprite(Coordinate2D initialLocation, Player player) {
        super("sprites/PlayerSprite.png", initialLocation, new Size(64, 64), 2, 4);
        this.player = player;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void explicitUpdate(long dt) {
        var mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        int centerPlayerXPos = (int) (this.getLocationInScene().getX() + this.getWidth() / 2);

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

}
