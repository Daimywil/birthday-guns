package org.maps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.api.scenes.TileMapContainer;

public abstract class Map extends TileMap {
    TileMapContainer tileMapContainer;

    public Map(TileMapContainer tileMapContainer, final Coordinate2D location, final Size size) {
        super(location, size);
        this.tileMapContainer = tileMapContainer;
    }

    public abstract int[][] defineMap();
}
