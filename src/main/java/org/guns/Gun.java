package org.guns;

import java.util.Calendar;

import org.projectiles.Projectile;
import org.scenes.GameScene;
import org.utilities.TimeUtils;

import com.github.hanyaeger.api.Coordinate2D;

public abstract class Gun {
    protected String name;
    protected float damage;
    protected float projectileSpeed;
    protected float fireRateMilliseconds;
    private GameScene gameScene;
    private long lastShotTime = 0;

    public Gun(String name, float damage, float projectileSpeed, float fireRateMilliseconds, GameScene gameScene) {
        this.name = name;
        this.damage = damage;
        this.projectileSpeed = projectileSpeed;
        this.fireRateMilliseconds = fireRateMilliseconds;
        this.gameScene = gameScene;
    }

    public void fire(Coordinate2D location, Coordinate2D direction) {
        lastShotTime = TimeUtils.getCurrentTimeInMillis();
        var projectile = createProjectile(location, direction);
        gameScene.addProjectile(projectile);
    }

    public boolean canFire() {
        long currentTime = TimeUtils.getCurrentTimeInMillis();
        return (currentTime - lastShotTime) >= fireRateMilliseconds;
    }

    protected abstract Projectile createProjectile(Coordinate2D initialLocation, Coordinate2D direction);
}
