package org.entities.sprites;

import org.utilities.MouseUtilities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import javafx.geometry.Point2D;

public class GunSprite extends DynamicSpriteEntity implements UpdateExposer {
    public GunSprite(Coordinate2D initialLocation) {
        super("sprites/Soesje_Gun(v1).png", initialLocation, new Size(48, 34), 1, 2);
    }

    @Override
    public void explicitUpdate(long dt) {

        var mousePosition = MouseUtilities.getMousePositionRelativeToScreen();
        Point2D centerPlayerPosition = this.getLocationInScene().add(getWidth() / 2, getHeight() / 2);
        Point2D unitDirection = mousePosition.subtract(centerPlayerPosition).normalize();
        double rotationDegrees = Math.toDegrees(Math.atan2(unitDirection.getX(), unitDirection.getY())) - 90;

        //final int GUN_OFFSET = 32;
        //int gunXPos = (int) (centerPlayerPosition.getX() + (int)(Math.cos(rotationDegrees) * GUN_OFFSET));
        //int gunYPos = (int) (centerPlayerPosition.getY() + (int)(Math.sin(rotationDegrees) * GUN_OFFSET));

        //System.out.println(new Coordinate2D(gunXPos, gunYPos));

        if (centerPlayerPosition.getX() <= mousePosition.getX()) {
            setCurrentFrameIndex(0);
            setRotate(rotationDegrees);
        } else {
            setCurrentFrameIndex(1);
            setRotate(rotationDegrees - 180);
        }
    }
}
