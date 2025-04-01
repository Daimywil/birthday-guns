package org.maps.Tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Fence extends CollidableTile {
    public Fence(Coordinate2D initialLocation, final Size size, String resource) {
        super(initialLocation, size, resource);
    }
}