package org.maps;

import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.api.scenes.TileMapContainer;

public abstract class Map extends TileMap {
    TileMapContainer tileMapContainer;

    public Map(TileMapContainer tileMapContainer) {
        this.tileMapContainer = tileMapContainer;
    }

    public abstract int[][] defineMap();
}
