package org.entities.sprites.guns;

import org.entities.characters.PlayerCharacter;
import org.utilities.MouseUtilities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import javafx.geometry.Point2D;

public abstract class GunSprite extends DynamicSpriteEntity implements UpdateExposer {
    protected PlayerCharacter player;

    protected GunSprite(String resource, Coordinate2D initialLocation, PlayerCharacter player) {
        super(resource, initialLocation, new Size(24, 17), 1, 2);
        this.player = player;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public abstract Coordinate2D getGunTip();

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

        Point2D gunOffset = unitDirection.multiply(20);
        setAnchorLocation(new Coordinate2D(gunOffset.getX(), gunOffset.getY()));
    }
}
