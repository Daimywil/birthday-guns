package org.maps.Tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Gate extends CollidableTile {
    public Gate(Coordinate2D initialLocation, final Size size, String resource) {
        super(initialLocation, size, resource);
    }
}