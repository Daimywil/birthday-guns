package org.guns;

import org.projectiles.Projectile;
import org.projectiles.SoesjesProjectile;
import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;

public class SoesjesGun extends Gun {
    public SoesjesGun(GameScene gameScene) {
        super("Soesjes Gun", 10, 2, 10, "sprites/guns/soesjes/gun.png", gameScene);
    }

    @Override
    protected Projectile createProjectile(Coordinate2D initialLocation, Coordinate2D direction) {
        return new SoesjesProjectile(initialLocation, direction, damage, gameScene);
    }
}
