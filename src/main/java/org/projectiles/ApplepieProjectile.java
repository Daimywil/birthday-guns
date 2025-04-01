package org.projectiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class ApplepieProjectile extends Projectile {
    public ApplepieProjectile(Coordinate2D initialLocation, Coordinate2D direction, float damage) {
        super("sprites/guns/applepie/projectile.png", initialLocation, direction, damage, new Size(20, 20));
    }
}
