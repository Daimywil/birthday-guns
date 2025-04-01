package org.projectiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SoesjesProjectile extends Projectile {
    public SoesjesProjectile(Coordinate2D initialLocation, Coordinate2D direction, float damage) {
        super("sprites/guns/soesjes/projectile.png", initialLocation, direction, damage, new Size(14, 14));
    }
}
