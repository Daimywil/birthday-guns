package org.entities.spawners;

import org.entities.characters.Zombie;
import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class ZombieSpawner extends EntitySpawner {

    private GameScene gameScene;
    private int viewOrder;

    public int[][] map;

    public ZombieSpawner(GameScene gameScene, int viewOrder, int[][] map) {
        super(1500);
        this.gameScene = gameScene;
        this.viewOrder = viewOrder;
        this.map = map;
    }

    @Override
    protected void spawnEntities() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == 3) {
                    Zombie zombie = new Zombie(new Coordinate2D(x * 32, y * 32), this.gameScene);
                    zombie.setViewOrder(viewOrder);
                    spawn(zombie);
                }
            }
        }
    }
}
