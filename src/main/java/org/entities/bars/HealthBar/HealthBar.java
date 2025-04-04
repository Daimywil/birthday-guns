package org.entities.bars.HealthBar;

import org.entities.characters.AliveCharacter;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class HealthBar extends DynamicCompositeEntity {
    private AliveCharacter aliveEntity;
    private Size size = new Size(50, 12);

    public HealthBar(AliveCharacter aliveEntity) {
        super(new Coordinate2D());
        this.aliveEntity = aliveEntity;
        setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        setAnchorLocationY(-40);
        setAnchorLocationX(-5);
    }

    @Override
    protected void setupEntities() {
        addEntity(new HealthBarBackground(size));
        addEntity(new HealthBarForeground(size, aliveEntity));
    }
}
