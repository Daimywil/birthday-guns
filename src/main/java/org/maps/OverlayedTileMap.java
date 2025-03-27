package org.maps;

import com.github.hanyaeger.api.scenes.TileMap;

public class OverlayedTileMap extends TileMap {
    private TilesetConfiguration tilesetConfiguration;
    private double viewOrder;

    public OverlayedTileMap(TilesetConfiguration tilesetConfiguration, double viewOrder) {
        this.tilesetConfiguration = tilesetConfiguration;
        this.viewOrder = viewOrder;
    }

    @Override
    public void setupEntities() {
        for (int index = 1; index < tilesetConfiguration.getAmountOfTiles(); index++) {
            addEntity(index, Tile.class, new TileConfiguration(tilesetConfiguration, index, (double) viewOrder));
        }
    }

    @Override
    public int[][] defineMap() {
        return tilesetConfiguration.tileMap;
    }
}
