package org.entities.spawners;

import org.entities.characters.Zombie;
import org.maps.Map;
import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class ZombieSpawner extends EntitySpawner {

    private GameScene gameScene;
    private int viewOrder;

    public Map map;

    public ZombieSpawner(GameScene gameScene, int viewOrder, Map map) {
        super(1500);
        this.gameScene = gameScene;
        this.viewOrder = viewOrder;
        this.map = map;
    }

    @Override
    protected void spawnEntities() {
        int[][] tileMap = map.defineMap();
        for (int y = 0; y < tileMap.length; y++) {
            for (int x = 0; x < tileMap[0].length; x++) {
                if (tileMap[y][x] == 3) {
                    Zombie zombie = new Zombie(new Coordinate2D(x * 32, y * 32), this.gameScene);
                    zombie.setViewOrder(viewOrder);
                    spawn(zombie);
                }
            }
        }
    }
}
