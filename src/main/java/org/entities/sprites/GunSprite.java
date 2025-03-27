package org.entities.sprites;

import org.utilities.MouseUtilities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import javafx.geometry.Point2D;

public class GunSprite extends DynamicSpriteEntity implements UpdateExposer {
    public GunSprite(String s, Coordinate2D initialLocation) {
        super("sprites/guns/soesjes/gun.png", initialLocation, new Size(48, 34), 1, 2);
    }

    @Override
    public void explicitUpdate(long dt) {
        //System.out.println(getLocationInScene());

        var mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        Point2D centerPlayerPosition = this.getLocationInScene().add(getWidth() / 2, getHeight() / 2);

        Point2D unitDirection = mousePosition.subtract(centerPlayerPosition).normalize();

        double rotationDegrees = Math.toDegrees(Math.atan2(unitDirection.getX(), unitDirection.getY())) - 90;

        if (centerPlayerPosition.getX() <= mousePosition.getX()) {
            setCurrentFrameIndex(0);
            setRotate(rotationDegrees);
        } else {
            setCurrentFrameIndex(1);
            setRotate(rotationDegrees - 180);
        }
    }
}
