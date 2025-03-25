package org.entities;

import com.github.hanyaeger.api.Coordinate2D;

public class Zombie extends AliveEntity {
    public Zombie(Coordinate2D initialLocation) {
        super(initialLocation, 100);
    }

    @Override
    protected void setupEntities() {

    }
}
