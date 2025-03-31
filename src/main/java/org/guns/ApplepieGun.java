package org.guns;

import org.projectiles.ApplepieProjectile;
import org.projectiles.Projectile;
import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;

public class ApplepieGun extends Gun {
    public ApplepieGun(GameScene gameScene) {
        super("Applepie Gun", 10, 2, 100, gameScene);
    }

    @Override
    protected Projectile createProjectile(Coordinate2D initialLocation, Coordinate2D direction) {
        return new ApplepieProjectile(initialLocation, direction);
    }
}
