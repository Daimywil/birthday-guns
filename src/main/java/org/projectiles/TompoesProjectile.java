package org.projectiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class TompoesProjectile extends Projectile {
    public TompoesProjectile(Coordinate2D initialLocation, Coordinate2D direction, float damage) {
        super("sprites/gun.png", initialLocation, direction, damage, new Size(20, 20));
    }
}
