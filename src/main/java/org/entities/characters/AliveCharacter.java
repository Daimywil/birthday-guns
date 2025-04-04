package org.entities.characters;

import org.entities.bars.HealthBar.HealthBar;
import org.utilities.TimeUtilities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public abstract class AliveCharacter extends DynamicCompositeEntity {
    private double health;
    private double maxHealth;
    private long lastTookDamageTime = 0;
    private int damageCooldownMilliseconds;
    private boolean isAlive = true;

    protected AliveCharacter(Coordinate2D initialLocation, double health, int damageCooldownMilliseconds) {
        super(initialLocation);
        this.health = health;
        this.maxHealth = health;
        this.damageCooldownMilliseconds = damageCooldownMilliseconds;
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
        long currentTime = TimeUtilities.getCurrentTimeInMillis();
        return currentTime - lastTookDamageTime > damageCooldownMilliseconds;
    }

    public double takeDamage(double damage) {
        if (!isAlive) {
            return 0;
        }
        if (!canTakeDamage()) {
            return 0;
        }
        damage = Math.min(damage, health);
        this.health -= damage;
        if (this.health == 0) {
            this.isAlive = false;
            onDeath();
        } else {
            this.lastTookDamageTime = TimeUtilities.getCurrentTimeInMillis();
        }
        return damage;
    }

    protected void onDeath() {
        remove();
    }
}
