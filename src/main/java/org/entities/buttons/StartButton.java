package org.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.BirthdayGuns;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;

import javafx.scene.input.MouseButton;

public class StartButton extends TextEntity implements MouseButtonReleasedListener {
    private BirthdayGuns birthdayGuns;

    public StartButton(Coordinate2D initialLocation, BirthdayGuns birthdayGuns) {
        super(initialLocation);
        this.birthdayGuns = birthdayGuns;
        setText("PLAY");
        setFont(Font.font("Roboto", FontWeight.BOLD, 64));
        setAnchorPoint(AnchorPoint.TOP_CENTER);
        setFill(Color.rgb(0, 0, 0));
        setViewOrder(10);
    }

    @Override
    public void onMouseButtonReleased(MouseButton button, Coordinate2D coordinate2d) {
        birthdayGuns.setActiveScene(1);
    }
}
