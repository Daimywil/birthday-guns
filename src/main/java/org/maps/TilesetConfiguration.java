package org.maps;

public class TilesetConfiguration {
    public String resource;
    public int columns;
    public int rows;

    public TilesetConfiguration(final String resource, final int columns, final int rows) {
        this.resource = resource;
        this.columns = columns;
        this.rows = rows;
    }
}
