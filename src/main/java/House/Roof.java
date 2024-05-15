package House;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Translate;

public class Roof {

    // Drawing a Box
    private Box roof;

    public Roof() {
        // Creating a Box
        roof = new Box();

        // Setting the properties of the Box
        roof.setWidth(200.0);
        roof.setHeight(100.0);
        roof.setDepth(200.0);

        Translate translate = new Translate();
        translate.setX(400);
        translate.setY(300);
        translate.setZ(75);

        roof.getTransforms().add(translate);
    }

    public Box getRoof() {
        return roof;
    }
}