package org.guns;

import org.projectiles.Projectile;
import org.scenes.GameScene;

import com.github.hanyaeger.api.Coordinate2D;

public abstract class Gun {
    protected String name;
    protected float damage;
    protected float projectileSpeed;
    protected float fireRate;
    private GameScene gameScene;

    public Gun(String name, float damage, float projectileSpeed, float fireRate, GameScene gameScene) {
        this.name = name;
        this.damage = damage;
        this.projectileSpeed = projectileSpeed;
        this.fireRate = fireRate;
        this.gameScene = gameScene;
    }

    public void fire(Coordinate2D location, Coordinate2D direction) {
        var projectile = createProjectile(location, direction);
        gameScene.addProjectile(projectile);
    }

    protected abstract Projectile createProjectile(Coordinate2D initialLocation, Coordinate2D direction);
}
