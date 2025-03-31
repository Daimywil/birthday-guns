package org.maps.Tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Tile extends SpriteEntity {

    public Tile(Coordinate2D initialLocation, final Size size, String resource) {
        super(resource, initialLocation, size);
    }
}
