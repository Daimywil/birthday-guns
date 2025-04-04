package org.maps.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

public class CollidableTile extends Tile implements Collider {
    public CollidableTile(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, size, resource);
    }
}
