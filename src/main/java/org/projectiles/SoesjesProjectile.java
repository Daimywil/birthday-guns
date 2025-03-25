package org.projectiles;

import com.github.hanyaeger.api.Coordinate2D;

public class SoesjesProjectile extends Projectile {
    public SoesjesProjectile(Coordinate2D initialLocation, Coordinate2D direction) {
        super("sprites/gun.png", initialLocation, direction);
    }
}
