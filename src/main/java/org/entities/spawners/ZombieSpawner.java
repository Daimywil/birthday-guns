package org.entities.spawners;

import org.entities.characters.Zombie;
import org.maps.Map;
import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.EntitySpawner;

import javafx.util.Pair;

public class ZombieSpawner extends EntitySpawner {
    private static final int spawnIntervalMilliseconds = 1500;

    private GameScene gameScene;
    private int viewOrder;

    public Map map;

    public ZombieSpawner(GameScene gameScene, int viewOrder, Map map) {
        super(spawnIntervalMilliseconds);
        this.gameScene = gameScene;
        this.viewOrder = viewOrder;
        this.map = map;
    }

    @Override
    protected void spawnEntities() {
        int[][] tileMap = map.defineMap();
        for (int y = 0; y < tileMap.length; y++) {
            for (int x = 0; x < tileMap[0].length; x++) {
                for (Pair<Integer, Direction> pair : map.getSpawnerTiles()) {
                    if (tileMap[y][x] == pair.getKey()) {
                        Direction direction = pair.getValue();
                        Coordinate2D spawnLocation = new Coordinate2D(x * GameScene.TILE_SIZE, y * GameScene.TILE_SIZE);
                        switch (direction) {
                            case UP:
                                spawnLocation = spawnLocation.add(new Coordinate2D(0, -GameScene.TILE_SIZE));
                                break;
                            case DOWN:
                                spawnLocation = spawnLocation.add(new Coordinate2D(0, GameScene.TILE_SIZE));
                                break;
                            case LEFT:
                                spawnLocation = spawnLocation.add(new Coordinate2D(-GameScene.TILE_SIZE, 0));
                                break;
                            case RIGHT:
                                spawnLocation = spawnLocation.add(new Coordinate2D(GameScene.TILE_SIZE, 0));
                                break;
                        }
                        Zombie zombie = new Zombie(spawnLocation, this.gameScene);
                        zombie.setViewOrder(viewOrder);
                        spawn(zombie);
                    }
                }
            }
        }
    }
}
