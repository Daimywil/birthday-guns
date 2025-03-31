package org.projectiles;

import com.github.hanyaeger.api.Coordinate2D;

public class WeddingCakeProjectile extends Projectile {
    public WeddingCakeProjectile(Coordinate2D initialLocation, Coordinate2D direction, float damage) {
        super("sprites/gun.png", initialLocation, direction, damage);
    }
}
