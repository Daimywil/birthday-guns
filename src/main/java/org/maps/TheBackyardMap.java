package org.maps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;

import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.ArrayList;

import org.maps.Tiles.*;
import org.scenes.GameScene;

public class TheBackyardMap extends Map {

    public static int[][] map = {
            {2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
    };


    public TheBackyardMap(GameScene gameScene, Coordinate2D location, Size size) {
        super(gameScene, location, size);

        setTilemap();
        gameScene.setBackgroundColor(Color.rgb(95, 178, 53));
    }

    @Override
    public void setupEntities() {
        addEntity(1, Grass.class, "sprites/maps/thebackyard/GrassTile(v1).png");
        addEntity(2, Fence.class,"sprites/maps/thebackyard/Fence(v1).png");
        addEntity(3, Gate.class,"sprites/maps/thebackyard/Gate(v1).png");
        addEntity(4, Pool.class,"sprites/maps/thebackyard/Pool.png");
        addEntity(5, StoneTile.class,"sprites/maps/thebackyard/StoneTile(v1).png");
        addEntity(6, Tree.class,"sprites/maps/thebackyard/Tree(v2).png");
        addEntity(90, Fence.class,"sprites/maps/thebackyard/Fence(v1).png");
        addEntity(91, Fence.class,"sprites/maps/thebackyard/FenceLeftBottomCorner(v1).png");
        addEntity(92, Fence.class,"sprites/maps/thebackyard/FenceLeftCorner(v1).png");
        addEntity(93, Fence.class,"sprites/maps/thebackyard/FenceRightBottomCorner(v1).png");
        addEntity(94, Fence.class,"sprites/maps/thebackyard/FenceRightCorner(v1).png");
        addEntity(95, Fence.class,"sprites/maps/thebackyard/FenceFlipped(v1).png");
    }

    private boolean isValidX(int x) {
        return x >= 0 && x < map[0].length;
    }

    private boolean isValidY(int y) {
        return y >= 0 && y < map.length;
    }

    private int[][] setTilemap() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                //Fence
                if (map[y][x] == 2) {
                    boolean hasLeft = isValidX(x - 1) && (map[y][x - 1] == 2 || map[y][x - 1] == 3 || map[y][x - 1] >= 90);
                    boolean hasRight = isValidX(x + 1) && (map[y][x + 1] == 2 || map[y][x + 1] == 3 || map[y][x + 1] >= 90);
                    boolean hasUp = isValidY(y - 1) && (map[y - 1][x] == 2 || map[y - 1][x] == 3 || map[y - 1][x] >= 90);
                    boolean hasDown = isValidY(y + 1) && (map[y + 1][x] == 2 || map[y + 1][x] == 3 || map[y + 1][x] >= 90);

                    if (hasLeft && hasRight) {
                        map[y][x] = 90;
                    } else if (hasLeft && hasUp) {
                        map[y][x] = 93;
                    } else if (hasRight && hasUp) {
                        map[y][x] = 91;
                    } else if (hasRight && hasDown) {
                        map[y][x] = 92;
                    } else if (hasLeft && hasDown) {
                        map[y][x] = 94;
                    } else {
                        map[y][x] = 95;
                    }
                }
                //Tree
                if (map[y][x] == 6) {
                    //
                }
            }
        }
        return map;
    }

    @Override
    public int[][] defineMap() {
        return map;
    }

    @Override
    public ArrayList<Pair<Integer, Direction>> getSpawnerTiles() {
        return new ArrayList<Pair<Integer, Direction>>() {{
            add(new Pair<>(5, Direction.DOWN));
        }};
    }
}
