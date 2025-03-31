package org.maps;

import com.github.hanyaeger.api.scenes.TileMapContainer;
import org.maps.Tiles.Fence;
import org.maps.Tiles.Gate;
import org.maps.Tiles.Grass;

public class TheBackyardMap extends Map {

    @Override
    public void setupEntities() {
        addEntity(1, Grass.class, "sprites/maps/thebackyard/GrassTile(v1).png");
        addEntity(2, Fence.class,"sprites/maps/thebackyard/Fence(v1).png");
        addEntity(3, Gate.class,"sprites/maps/thebackyard/Gate(v1).png");
    }

    public TheBackyardMap(TileMapContainer tileMapContainer) {
        super(tileMapContainer);
    }

    @Override
    public int[][] defineMap() {
        return new int[][] {
                {2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 2, 2, 2, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
    }
}
