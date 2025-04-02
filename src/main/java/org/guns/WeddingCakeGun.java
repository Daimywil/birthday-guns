package org.guns;

import org.projectiles.Projectile;
import org.projectiles.WeddingCakeProjectile;
import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;

public class WeddingCakeGun extends Gun{
    public WeddingCakeGun(GameScene gameScene) {
        super("Wedding Cake Gun", 100, 3, 1000, "sprites/guns/weddingcake/gun.png", gameScene);
    }

    @Override
    protected Projectile createProjectile(Coordinate2D initialLocation, Coordinate2D direction) {
        return new WeddingCakeProjectile(initialLocation, direction, damage);
    }
}
