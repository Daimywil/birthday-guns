package org.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.BirthdayGuns;

public class ButtonBackdrop extends RectangleEntity {
    private BirthdayGuns birthdayGuns;

    public ButtonBackdrop(Coordinate2D initialLocation, BirthdayGuns birthdayGuns) {
        super(initialLocation);
        this.birthdayGuns = birthdayGuns;
        setAnchorPoint(AnchorPoint.TOP_CENTER);
        setFill(Color.rgb(255, 255, 0));
        setWidth(256);
        setHeight(96);
    }
}
