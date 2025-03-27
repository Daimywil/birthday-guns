package org.maps;

public class TileConfiguration {
    public int frameIndex;
    public TilesetConfiguration tilesetConfiguration;
    public double viewOrder;

    public TileConfiguration(final TilesetConfiguration tilesetConfiguration, final int frameIndex, final double viewOrder) {
        this.tilesetConfiguration = tilesetConfiguration;
        this.frameIndex = frameIndex;
        this.viewOrder = viewOrder;
    }
}
