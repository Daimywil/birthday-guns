package org.maps;

public class TileConfiguration {
    public int frameIndex;
    public TilesetConfiguration tilesetConfiguration;

    public TileConfiguration(TilesetConfiguration tilesetConfiguration, final int frameIndex) {
        this.tilesetConfiguration = tilesetConfiguration;
        this.frameIndex = frameIndex;
    }
}
