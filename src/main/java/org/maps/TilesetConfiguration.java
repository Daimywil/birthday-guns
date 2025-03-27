package org.maps;

public class TilesetConfiguration {
    public String resource;
    public int columns;
    public int rows;
    public int[][] tileMap;

    public TilesetConfiguration(final String resource, final int columns, final int rows, int[][] tileMap) {
        this.resource = resource;
        this.columns = columns;
        this.rows = rows;
        this.tileMap = tileMap;
    }

    public int getAmountOfTiles() {
        return columns * rows;
    }
}
