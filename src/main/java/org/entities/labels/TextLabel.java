package org.entities.labels;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.BirthdayGuns;

public class TextLabel extends TextEntity {
    private BirthdayGuns birthdayGuns;

    public TextLabel(Coordinate2D initialLocation, BirthdayGuns birthdayGuns) {
        super(initialLocation);
        this.birthdayGuns = birthdayGuns;
        setFont(Font.font("Roboto", FontWeight.BOLD, 64));
        setAnchorPoint(AnchorPoint.TOP_CENTER);
        setFill(Color.rgb(0, 0, 0));
        setViewOrder(10);
    }
}
