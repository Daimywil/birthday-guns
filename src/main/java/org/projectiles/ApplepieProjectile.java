package org.projectiles;

import com.github.hanyaeger.api.Coordinate2D;

public class ApplepieProjectile extends Projectile {
    public ApplepieProjectile(Coordinate2D initialLocation, Coordinate2D direction) {
        super("sprites/gun.png", initialLocation, direction);
    }
}
