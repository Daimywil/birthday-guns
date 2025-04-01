package org.entities.spawners;

import org.entities.characters.Zombie;
import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class ZombieSpawner extends EntitySpawner {
    private GameScene gameScene;
    private int viewOrder;

    public ZombieSpawner(GameScene gameScene, int viewOrder) {
        super(1500);
        this.gameScene = gameScene;
        this.viewOrder = viewOrder;
    }

    @Override
    protected void spawnEntities() {
        Zombie zombie = new Zombie(new Coordinate2D(50, 50), this.gameScene);
        zombie.setViewOrder(viewOrder);
        spawn(zombie);
    }
}
