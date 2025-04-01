package org.entities;

import org.entities.bars.HealthBar.HealthBar;
import org.utilities.TimeUtils;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public abstract class AliveEntity extends DynamicCompositeEntity {
    private double health;
    private double maxHealth;
    private long lastTookDamageTime = 0;
    private int damageCooldownMilliseconds;
    private boolean isAlive = true;

    protected AliveEntity(Coordinate2D initialLocation, double health, int damageCooldownMilliseconds) {
        super(initialLocation);
        this.health = health;
        this.maxHealth = health;
        this.damageCooldownMilliseconds = damageCooldownMilliseconds;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(new HealthBar(this));
    }

    public double getHealth() {
        return health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    private boolean canTakeDamage() {
        if (!isAlive) {
            return false;
        }
        long currentTime = TimeUtils.getCurrentTimeInMillis();
        return currentTime - lastTookDamageTime > damageCooldownMilliseconds;
    }

    public void takeDamage(float damage) {
        if (!isAlive) {
            return;
        }
        if (!canTakeDamage()) {
            return;
        }
        this.health = Math.max(0, this.health - damage);
        if (this.health == 0) {
            this.isAlive = false;
            onDeath();
        } else {
            this.lastTookDamageTime = TimeUtils.getCurrentTimeInMillis();
        }
    }

    protected void onDeath() {
        remove();
    }
}
