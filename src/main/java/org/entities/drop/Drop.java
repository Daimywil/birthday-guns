package org.entities.drop;

import java.util.List;

import org.entities.characters.Player;
import org.guns.Gun;
import org.utilities.TimeUtils;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Drop extends DynamicSpriteEntity implements UpdateExposer, Collided {
    private long initTimestamp = TimeUtils.getCurrentTimeInMillis();
    private int lifetimeSeconds = 1;

    protected Drop(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(40, 40), 1, 2);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void explicitUpdate(long timestamp) {
        timestamp = TimeUtils.getCurrentTimeInMillis();
        setRotate(timestamp / 2);
        if (timestamp - initTimestamp > lifetimeSeconds * 1000) {
            remove();
        }
    }

    protected abstract void grantDrop(Player player);

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (Collider collider : collidingObjects) {
            if (!(collider instanceof Player)) {
                continue;
            }
            Player player = (Player) collider;
            grantDrop(player);
            remove();
            break;
        }
    }
}
