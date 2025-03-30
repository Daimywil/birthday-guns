package org.maps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Grass extends SpriteEntity implements Collider {
    public Grass(Coordinate2D initialLocation, final Size size, String resource) {
        super(resource, initialLocation, size);
    }
}
