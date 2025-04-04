package org.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import javafx.scene.input.MouseButton;
import org.BirthdayGuns;
import org.entities.labels.TextLabel;
import org.scenes.GameScene;

public class MapButton extends SpriteEntity implements MouseButtonReleasedListener {
    private BirthdayGuns birthdayGuns;
    private int mapButtonNumber;
    private TextLabel currentMapLabel;
    private String mapName;

    public MapButton(String resource, Coordinate2D initialLocation, BirthdayGuns birthdayGuns, int mapButtonNumber, TextLabel currentMapLabel, String mapName) {
        super(resource, initialLocation);
        this.birthdayGuns = birthdayGuns;
        this.mapButtonNumber = mapButtonNumber;
        this.currentMapLabel = currentMapLabel;
        this.mapName = mapName;
        setAnchorPoint(AnchorPoint.TOP_CENTER);
        setViewOrder(10);
    }

    @Override
    public void onMouseButtonReleased(MouseButton button, Coordinate2D coordinate2d) {
        GameScene.mapNumber = mapButtonNumber;
        currentMapLabel.setText("Current map: " + mapName);
    }
}
