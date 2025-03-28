package org.entities.sprites;

import org.entities.characters.Player;
import org.utilities.MouseUtilities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import javafx.geometry.Point2D;

public class GunSprite extends DynamicSpriteEntity implements UpdateExposer {
    private Player player;

    public GunSprite(String resource, Coordinate2D initialLocation, Player player) {
        super(resource, initialLocation, new Size(48, 34), 1, 2);
        this.player = player;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public Coordinate2D getGunTip() {
        Coordinate2D aimDirection = player.getMouseAimDirection();

        Coordinate2D topDirection = new Coordinate2D(-aimDirection.getY(), aimDirection.getX());

        Point2D centerPlayerPosition = player.getAbsoluteCenterPosition().add(getWidth() / 2, getHeight() / 2);

        Coordinate2D mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        boolean isOnLeftSide = centerPlayerPosition.getX() >= mousePosition.getX();

        return getLocationInScene().add(aimDirection.multiply(42)).add(topDirection.multiply(12 * (isOnLeftSide ? 1 : -1)));
    }

    @Override
    public void explicitUpdate(long dt) {
        Coordinate2D mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        Point2D centerPlayerPosition = player.getAbsoluteCenterPosition();

        Coordinate2D unitDirection = player.getMouseAimDirection();

        double rotationDegrees = Math.toDegrees(Math.atan2(unitDirection.getX(), unitDirection.getY())) - 90;

        if (centerPlayerPosition.getX() <= mousePosition.getX()) {
            setCurrentFrameIndex(0);
            setRotate(rotationDegrees);
        } else {
            setCurrentFrameIndex(1);
            setRotate(rotationDegrees - 180);
        }

        Point2D gunOffset = unitDirection.multiply(40);
        setAnchorLocation(new Coordinate2D(gunOffset.getX(), gunOffset.getY()));
    }
}
