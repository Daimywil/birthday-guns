package org.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public abstract class AliveEntity extends DynamicCompositeEntity {
    private double health;
    private double maxHealth;

    protected AliveEntity(Coordinate2D initialLocation, double health) {
        super(initialLocation);
        this.health = health;
        this.maxHealth = health;
    }

    public void takeDamage(float damage) {
        this.health = Math.max(0, this.health - damage);
        if (this.health == 0) {
            onDeath();
        }
    }

    private void onDeath() {
        remove();
    }
}
