package org.entities.spawners;

import org.entities.characters.Zombie;
import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class ZombieSpawner extends EntitySpawner {
    private GameScene gameScene;

    public ZombieSpawner(GameScene gameScene) {
        super(500);
        this.gameScene = gameScene;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Zombie(new Coordinate2D(50, 50), this.gameScene));
    }
}
