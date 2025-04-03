package org.entities.sprites.guns;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.geometry.Point2D;
import org.entities.characters.PlayerCharacter;
import org.utilities.MouseUtilities;

public class WeddingCakeGunSprite extends GunSprite {
    public WeddingCakeGunSprite(Coordinate2D initialLocation, PlayerCharacter player) {
        super("sprites/guns/weddingcake/gun.png", initialLocation, player);
    }

    @Override
    public Coordinate2D getGunTip() {
        Coordinate2D aimDirection = player.getMouseAimDirection();

        Coordinate2D topDirection = new Coordinate2D(-aimDirection.getY(), aimDirection.getX());

        Point2D centerPlayerPosition = player.getAbsoluteCenterPosition().add(getWidth() / 2, getHeight() / 2);

        Coordinate2D mousePosition = MouseUtilities.getMousePositionRelativeToScreen();

        boolean isOnLeftSide = centerPlayerPosition.getX() >= mousePosition.getX();

        return getLocationInScene().add(aimDirection.multiply(30)).add(topDirection.multiply(2 * (isOnLeftSide ? 1 : -1)));
    }
}
