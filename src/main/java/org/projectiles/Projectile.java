package org.projectiles;

import java.util.ArrayList;
import java.util.List;

import org.entities.characters.Zombie;
import org.maps.Tiles.CollidableTile;
import org.utilities.CoordinateUtilities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public abstract class Projectile extends DynamicSpriteEntity implements Newtonian, SceneBorderCrossingWatcher, Collided {
    private float damage;
    private ArrayList<Collider> collidersHit = new ArrayList<>();

    protected Projectile(String resource, Coordinate2D initialLocation, Coordinate2D direction, float damage, Size size) {
        super(resource, initialLocation, size);
        this.damage = damage;
        setFrictionConstant(0);
        setGravityConstant(0);
        setGravityDirection(0);
        setMotion(5, CoordinateUtilities.convertDirectionToDegrees(direction));
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (Collider collider : collidingObjects) {
            if (collider instanceof Zombie) {
                if (collidersHit.contains(collider)) {
                    continue;
                }
                collidersHit.add(collider);
                Zombie zombie = (Zombie) collider;
                zombie.takeDamage(damage);
            } else if (collider instanceof CollidableTile) {
                remove();
            }
        }
    }
}
