package org.entities.bars.healthbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

import javafx.scene.paint.Color;

public class HealthBarBackground extends RectangleEntity {
    public HealthBarBackground(Size size) {
        super(new Coordinate2D(), size);
        setFill(Color.GREY);
    }
}
