package org.maps;

import java.util.ArrayList;

import org.maps.tiles.CollidableTile;
import org.maps.tiles.Tile;
import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;

import javafx.scene.paint.Color;
import javafx.util.Pair;

public class TheDungeonMap extends Map {
    public TheDungeonMap(GameScene gameScene, Coordinate2D location, Size size) {
        super(gameScene, location, size);
        gameScene.setBackgroundColor(Color.rgb(156, 223, 240));
    }

    private String getAssetPath(String name) {
        return String.format("sprites/maps/thedungeon/%s.png", name);
    }

    @Override
    public void setupEntities() {
        addEntity(1, Tile.class, getAssetPath("floor"));
        addEntity(2, CollidableTile.class, getAssetPath("wall-background"));
        addEntity(3, CollidableTile.class, getAssetPath("wall-bottom"));
        addEntity(4, CollidableTile.class, getAssetPath("corner-bottom-left"));
        addEntity(5, CollidableTile.class, getAssetPath("corner-bottom-right"));
        addEntity(6, CollidableTile.class, getAssetPath("wall-right"));
        addEntity(7, CollidableTile.class, getAssetPath("corner-top-right"));
        addEntity(8, CollidableTile.class, getAssetPath("corner-top-left"));
        addEntity(9, CollidableTile.class, getAssetPath("wall-top"));
        addEntity(10, CollidableTile.class, getAssetPath("wall-left"));
        addEntity(11, CollidableTile.class, getAssetPath("wall-corner-top-left"));
        addEntity(12, CollidableTile.class, getAssetPath("wall-corner-bottom-left"));
        addEntity(13, CollidableTile.class, getAssetPath("wall-corner-top-right"));
        addEntity(14, CollidableTile.class, getAssetPath("wall-corner-bottom-right"));
        addEntity(15, CollidableTile.class, getAssetPath("door-left"));
        addEntity(16, CollidableTile.class, getAssetPath("door-right"));
    }

    @Override
    public int[][] defineMap() {
        return new int[][] {
            {5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 0, 0, 0, 0, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4},
            {6, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10, 0, 0, 0, 0, 6, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 0, 0, 0, 0, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 0, 0, 0, 0, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 12, 3, 3, 3, 3, 14, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 15},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {16, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {16, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 9, 9, 9, 9, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 0, 0, 0, 0, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 0, 0, 0, 0, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {7, 9, 9, 13, 1, 1, 1, 1, 11, 9, 9, 9, 8, 0, 0, 0, 0, 7, 9, 9, 9, 13, 1, 1, 1, 1, 11, 9, 9, 8},
            {0, 0, 0, 6, 1, 1, 1, 1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 1, 1, 1, 1, 10, 0, 0, 0},
            {0, 0, 0, 6, 1, 1, 1, 1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 1, 1, 1, 1, 10, 0, 0, 0},
            {0, 0, 0, 6, 1, 1, 1, 1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 1, 1, 1, 1, 10, 0, 0, 0},
            {0, 0, 0, 6, 1, 1, 1, 1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 1, 1, 1, 1, 10, 0, 0, 0},
            {5, 3, 3, 14, 1, 1, 1, 1, 12, 3, 3, 3, 4, 0, 0, 0, 0, 5, 3, 3, 3, 14, 1, 1, 1, 1, 12, 3, 3, 4},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 0, 0, 0, 0, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 0, 0, 0, 0, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 12, 3, 3, 3, 3, 14, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 15},
            {16, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 15},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 9, 9, 9, 9, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 0, 0, 0, 0, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 0, 0, 0, 0, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 0, 0, 0, 0, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
            {7, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 0, 0, 0, 0, 7, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8}
        };
    }

    @Override
    public ArrayList<Pair<Integer, Direction>> getSpawnerTiles() {
        return new ArrayList<Pair<Integer, Direction>>() {{
            add(new Pair<>(15, Direction.LEFT));
            add(new Pair<>(16, Direction.RIGHT));
        }};
    }

    @Override
    public Coordinate2D getSpawnLocation() {
        return new Coordinate2D(GameScene.TILE_SIZE * 5, GameScene.TILE_SIZE * 5);
    }
}
