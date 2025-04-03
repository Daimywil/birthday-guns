package org.maps;

import java.util.ArrayList;

import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.scenes.TileMap;

import javafx.util.Pair;

public abstract class Map extends TileMap {
    GameScene gameScene;

    public Map(GameScene gameScene, final Coordinate2D location, final Size size) {
        super(location, size);
        this.gameScene = gameScene;
    }

    public abstract ArrayList<Pair<Integer, Direction>> getSpawnerTiles();
}
