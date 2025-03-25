package org.utilities;

import com.github.hanyaeger.api.Coordinate2D;

public final class CoordinateUtilities {

    private CoordinateUtilities() {}

    public static double convertDirectionToDegrees(Coordinate2D direction) {
        direction = direction.normalize();
        return Math.toDegrees(Math.atan2(direction.getX(), direction.getY()));
    }
}