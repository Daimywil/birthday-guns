package org.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.BirthdayGuns;
import org.scenes.GameScene;

import javax.swing.*;
import java.util.Optional;

public class MapButton extends SpriteEntity implements MouseButtonReleasedListener {
    private BirthdayGuns birthdayGuns;
    private int mapButtonNumber;

    public MapButton(String resource, Coordinate2D initialLocation, BirthdayGuns birthdayGuns, int mapButtonNumber) {
        super(resource, initialLocation);
        this.birthdayGuns = birthdayGuns;
        this.mapButtonNumber = mapButtonNumber;
        setAnchorPoint(AnchorPoint.TOP_CENTER);
        setViewOrder(10);
    }

    @Override
    public void onMouseButtonReleased(MouseButton button, Coordinate2D coordinate2d) {
        GameScene.mapNumber = mapButtonNumber;
    }
}
