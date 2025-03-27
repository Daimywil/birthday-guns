package org.maps;

import com.github.hanyaeger.api.scenes.TileMapContainer;

public abstract class Map {
    private TileMapContainer tileMapContainer;

    protected Map(TileMapContainer tileMapContainer, TilesetConfiguration[] tilesetConfiguration) {
        this.tileMapContainer = tileMapContainer;
        for (int index = 0; index < tilesetConfiguration.length; index++) {
            addTilesetOverlay(tilesetConfiguration[index], index);
        }
    }

    private void addTilesetOverlay(TilesetConfiguration tilesetConfiguration, int index) {
        tileMapContainer.addTileMap(new OverlayedTileMap(tilesetConfiguration, (double) index));
    }
}
