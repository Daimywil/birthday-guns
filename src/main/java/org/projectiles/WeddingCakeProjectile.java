package org.projectiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class WeddingCakeProjectile extends Projectile {
    public WeddingCakeProjectile(Coordinate2D initialLocation, Coordinate2D direction, float damage) {
        super("sprites/guns/weddingcake/projectile.png", initialLocation, direction, damage, new Size(16, 16));
    }
}
