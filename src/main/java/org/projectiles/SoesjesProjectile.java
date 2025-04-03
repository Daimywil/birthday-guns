package org.projectiles;

import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SoesjesProjectile extends Projectile {
    public SoesjesProjectile(Coordinate2D initialLocation, Coordinate2D direction, float damage, GameScene gameScene) {
        super("sprites/guns/soesjes/projectile.png", initialLocation, direction, damage, new Size(8, 8), gameScene);
    }
}
