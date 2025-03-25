package org.entities.buttons;

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
        setText("START");
    }

    @Override
    public void onMouseButtonReleased(MouseButton button, Coordinate2D coordinate2d) {
        birthdayGuns.setActiveScene(1);
    }
}
