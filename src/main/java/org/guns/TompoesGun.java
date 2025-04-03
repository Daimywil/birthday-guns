package org.guns;

import org.projectiles.Projectile;
import org.projectiles.TompoesProjectile;
import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;

public class TompoesGun extends Gun {
    public TompoesGun(GameScene gameScene) {
        super("Tompoes Gun", 10, 2, 2, "sprites/guns/tompoes/gun.png", gameScene);
    }

    @Override
    protected Projectile createProjectile(Coordinate2D initialLocation, Coordinate2D direction) {
        return new TompoesProjectile(initialLocation, direction, damage, gameScene);
    }
}
