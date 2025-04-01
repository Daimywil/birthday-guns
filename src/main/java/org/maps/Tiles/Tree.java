package org.maps.Tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Tree extends CollidableTile {
    public Tree(Coordinate2D initialLocation, final Size size, String resource) {
        super(initialLocation, size, resource);
    }
}