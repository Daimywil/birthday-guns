package org.maps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Tile extends SpriteEntity {
    public Tile(final Coordinate2D location, final Size size, final TileConfiguration tileConfiguration) {
        super(tileConfiguration.tilesetConfiguration.resource, location, size, tileConfiguration.tilesetConfiguration.rows, tileConfiguration.tilesetConfiguration.columns);
        setCurrentFrameIndex(tileConfiguration.frameIndex);
    }
}
