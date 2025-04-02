package org.entities.characters;

import java.util.List;
import java.util.Random;

import org.entities.AliveEntity;
import org.entities.sprites.ZombieSprite;
import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;

public class Zombie extends AliveEntity implements Newtonian, UpdateExposer, Collider, Collided {
    private ZombieSprite zombieSprite = new ZombieSprite(new Coordinate2D(), this);
    private double speed = new Random().nextDouble(0.75, 1.25);
    private GameScene gameScene;

    public Zombie(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation, 100, 0);
        this.gameScene = gameScene;
        setFrictionConstant(0.25);
        setGravityConstant(0);
        setGravityDirection(0);
    }

    @Override
    protected void setupEntities() {
        addEntity(zombieSprite);
    }

    @Override
    public void explicitUpdate(long deltaTime) {
        Player player = gameScene.getPlayer();

        if (player != null) {
            Coordinate2D directionToPlayer = player.getAbsoluteCenterPosition().subtract(getLocationInScene()).normalize();
            double angle = Math.toDegrees(Math.atan2(directionToPlayer.getX(), directionToPlayer.getY()));
            setMotion(speed, angle);
        }
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        for (Collider collider : collidingObjects) {
            if (collider instanceof Player) {
                Player player = (Player) collider;
                player.takeDamage(10);
                break;
            }
        }
    }

    @Override
    protected void onDeath() {
        gameScene.onZombieDeath(this);
        remove();
    }
}
