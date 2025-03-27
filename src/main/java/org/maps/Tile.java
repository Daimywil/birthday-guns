package org.maps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Tile extends DynamicSpriteEntity {
    public Tile(final Coordinate2D location, TileConfiguration tileConfiguration) {
        super(tileConfiguration.tilesetConfiguration.resource, location, tileConfiguration.tilesetConfiguration.columns, tileConfiguration.tilesetConfiguration.rows);
        setCurrentFrameIndex(tileConfiguration.frameIndex);
    }
}
