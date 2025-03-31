package org.entities.bars.HealthBar;

import org.entities.AliveEntity;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;

import javafx.scene.paint.Color;

public class HealthBarForeground extends DynamicRectangleEntity implements UpdateExposer {
    private AliveEntity aliveEntity;
    private Size size;
    private static int PADDING = 6;

    public HealthBarForeground(Size size, AliveEntity aliveEntity) {
        super(new Coordinate2D(), new Size(size.width() - PADDING, size.height() - PADDING));
        this.size = size;
        this.aliveEntity = aliveEntity;
        setAnchorLocationX(PADDING / 2);
        setAnchorLocationY(PADDING / 2);
        setFill(Color.RED);
    }

    @Override
    public void explicitUpdate(long timestamp) {
        setWidth(aliveEntity.getHealth() / aliveEntity.getMaxHealth() * (size.width() - PADDING));
    }
}
