package org.entities.sprites;

import org.entities.characters.Zombie;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;

public class ZombieSprite extends CharacterSprite {
    private final Zombie zombie;

    public ZombieSprite(Coordinate2D initialLocation, Zombie zombie) {
        super("sprites/characters/zombie.png", initialLocation);
        this.zombie = zombie;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    protected boolean isWalking() {
        return this.zombie.getSpeed() > 0;
    }

    @Override
    protected boolean isWalkingLeft() {
        return this.zombie.getDirection() <= 180;
    }

}
