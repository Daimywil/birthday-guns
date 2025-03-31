package org.projectiles;

import com.github.hanyaeger.api.Coordinate2D;

public class ApplepieProjectile extends Projectile {
    public ApplepieProjectile(Coordinate2D initialLocation, Coordinate2D direction, float damage) {
        super("sprites/guns/applepie/projectile.png", initialLocation, direction, damage);
    }
}
