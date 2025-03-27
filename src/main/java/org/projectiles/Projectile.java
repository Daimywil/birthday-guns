package org.projectiles;

import org.utilities.CoordinateUtilities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public abstract class Projectile extends DynamicSpriteEntity implements Newtonian, SceneBorderCrossingWatcher {
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
}
