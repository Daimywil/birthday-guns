package org.entities.sprites.guns;

import org.entities.characters.Player;
import org.utilities.MouseUtilities;

import com.github.hanyaeger.api.Coordinate2D;

import javafx.geometry.Point2D;

public class ApplepieGunSprite extends GunSprite {
    public ApplepieGunSprite(Coordinate2D initialLocation, Player player) {
        super("sprites/guns/applepie/gun.png", initialLocation, player);
    }

    @Override
    public Coordinate2D getGunTip() {
        Coordinate2D aimDirection = player.getMouseAimDirection();

        Coordinate2D topDirection = new Coordinate2D(-aimDirection.getY(), aimDirection.getX());

        Point2D centerPlayerPosition = player.getAbsoluteCenterPosition().add(getWidth() / 2, getHeight() / 2);

        Coordinate2D mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        boolean isOnLeftSide = centerPlayerPosition.getX() >= mousePosition.getX();

        return getLocationInScene().add(aimDirection.multiply(12)).add(topDirection.multiply(12 * (isOnLeftSide ? 1 : -1)));
    }
}
