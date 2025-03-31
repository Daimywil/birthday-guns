package org.maps.Tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

public class Gate extends Tile implements Collider {
    public Gate(Coordinate2D initialLocation, final Size size, String resource) {
        super(initialLocation, size, resource);
    }
}