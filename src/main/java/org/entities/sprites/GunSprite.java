package org.entities.sprites;

import org.utilities.MouseUtilities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import javafx.geometry.Point2D;

public class GunSprite extends DynamicSpriteEntity implements UpdateExposer {
    public GunSprite(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(48, 34), 1, 1);
    }

    @Override
    public void explicitUpdate(long dt) {
        var mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        Point2D centerPlayerPosition = this.getLocationInScene().add(getWidth() / 2, getHeight() / 2);

        Point2D unitDirection = mousePosition.subtract(centerPlayerPosition).normalize();

        double rotationDegrees = Math.toDegrees(Math.atan2(unitDirection.getX(), unitDirection.getY())) - 90;

        setRotate(rotationDegrees);
    }
}
