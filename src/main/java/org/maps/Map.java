package org.maps;

import com.github.hanyaeger.api.scenes.TileMap;

public abstract class Map extends TileMap {
    protected void addTile(int identifier, TilesetConfiguration tilesetConfiguration) {
        addEntity(identifier, Tile.class, new TileConfiguration(tilesetConfiguration, identifier));
    }
}
