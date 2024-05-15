package Rotation;

import House.Roof;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;

import java.util.concurrent.atomic.AtomicReference;

public class Rotation {
    public static void setupRotation(Box box, Group root, Scene scene) {
        AtomicReference<Double> mousePosX = new AtomicReference<>((double) 0);
        AtomicReference<Double> mousePosY = new AtomicReference<>((double) 0);

        // Rotate the box
        Rotate rotateX = new Rotate(45, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(45, Rotate.Y_AXIS);
        box.getTransforms().addAll(rotateX, rotateY);

        // Rotate the box only around Y-axis
        Rotate rotateYY = new Rotate(0, Rotate.Y_AXIS);
        box.getTransforms().add(rotateYY);

        //Creating a slider to control rotation
        Slider slider = new Slider(0, 360, 0);
        slider.setLayoutX(300);
        slider.setLayoutY(500);
        slider.setPrefWidth(200);

        // Bind rotation angle to slider value
        rotateYY.angleProperty().bind(slider.valueProperty());

        // Mouse interaction to rotate the box
        scene.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                mousePosX.set(event.getSceneX());
                mousePosY.set(event.getSceneY());
            }
        });

        scene.setOnMouseDragged(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                double deltaX = event.getSceneX() - mousePosX.get();
                double deltaY = event.getSceneY() - mousePosY.get();

                rotateX.setAngle(rotateX.getAngle() + deltaY);
                rotateY.setAngle(rotateY.getAngle() - deltaX);

                mousePosX.set(event.getSceneX());
                mousePosY.set(event.getSceneY());
            }
        });

        // Add the slider to the root group
        root.getChildren().add(slider);
    }
}