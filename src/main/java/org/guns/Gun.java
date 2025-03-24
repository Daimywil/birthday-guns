package org.guns;

import org.projectiles.Projectile;

public abstract class Gun {
    protected String name;
    protected float damage;
    protected float projectileSpeed;
    protected float fireRate;
    protected Class<Projectile> projectileClass;

    public Gun(String name, float damage, float projectileSpeed, float fireRate) {
        this.name = name;
        this.damage = damage;
        this.projectileSpeed = projectileSpeed;
        this.fireRate = fireRate;
    }

    public void fire() {

    }
}
