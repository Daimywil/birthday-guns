package org.maps;

import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;

public abstract class Map extends TileMap {
    GameScene gameScene;

    public Map(GameScene gameScene, final Coordinate2D location, final Size size) {
        super(location, size);
        this.gameScene = gameScene;
    }

    public int[][] defineMap() {
        return null;
    }
}
