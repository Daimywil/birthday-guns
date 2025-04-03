package org.projectiles;

import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class ApplepieProjectile extends Projectile {
    public ApplepieProjectile(Coordinate2D initialLocation, Coordinate2D direction, float damage, GameScene gameScene) {
        super("sprites/guns/applepie/projectile.png", initialLocation, direction, damage, new Size(11, 19), gameScene);
    }
}
