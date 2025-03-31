package org.guns;

import org.projectiles.Projectile;
import org.projectiles.WeddingCakeProjectile;
import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;

public class WeddingCakeGun extends Gun{
    public WeddingCakeGun(GameScene gameScene) {
        super("Wedding Cake Gun", 10, 2, 2, gameScene);
    }

    @Override
    protected Projectile createProjectile(Coordinate2D initialLocation, Coordinate2D direction) {
        return new WeddingCakeProjectile(initialLocation, direction, damage);
    }
}
