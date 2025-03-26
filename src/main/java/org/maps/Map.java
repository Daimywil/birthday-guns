package org.maps;

import com.github.hanyaeger.api.scenes.TileMap;

public abstract class Map extends TileMap {
    protected void addTile(int identifier, String resource) {
        addEntity(identifier, Tile.class, resource);
    }
}
