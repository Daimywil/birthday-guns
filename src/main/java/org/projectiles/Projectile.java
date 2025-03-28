package org.projectiles;

import java.util.List;

import org.entities.characters.Zombie;
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
    protected Projectile(String resource, Coordinate2D initialLocation, Coordinate2D direction) {
        super(resource, initialLocation, new Size(20, 20));
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
                Zombie zombie = (Zombie) collider;
                zombie.remove();
                remove();
            }
        }
    }
}
