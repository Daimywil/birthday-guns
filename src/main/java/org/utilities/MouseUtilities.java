package org.utilities;

import com.github.hanyaeger.api.Coordinate2D;

import javafx.stage.Stage;
import java.awt.*;

public final class MouseUtilities {

    private MouseUtilities() {}

    public static Coordinate2D getMousePositionRelativeToScreen() {
        Point mousePos = MouseInfo.getPointerInfo().getLocation();
        int windowPositionX = (int) Stage.getWindows().get(0).getX();
        int windowPositionY = (int) Stage.getWindows().get(0).getY();
        return new Coordinate2D(mousePos.x - windowPositionX, mousePos.y - windowPositionY);
    }
}