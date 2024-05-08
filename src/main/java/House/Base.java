package House;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Base extends Application {

    private double mousePosX, mousePosY = 0;

    @Override
    public void start(Stage stage) {
        // Drawing a Box
        Box box = new Box();

        // Setting the properties of the Box
        box.setWidth(200.0);
        box.setHeight(200.0);
        box.setDepth(200.0);

        Translate translate = new Translate();
        translate.setX(400);
        translate.setY(300);
        translate.setZ(25);

        box.getTransforms().add(translate);

        // Rotate the box
        Rotate rotateX = new Rotate(45, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(45, Rotate.Y_AXIS);
        box.getTransforms().addAll(rotateX, rotateY);

        // Rotate the box only around Y-axis
        Rotate rotateYY = new Rotate(0, Rotate.Y_AXIS);
        box.getTransforms().add(rotateYY);

        //Creating a Group object
        Group root = new Group(box);

        //Creating a slider to control rotation
        Slider slider = new Slider(0, 360, 0);
        slider.setLayoutX(300);
        slider.setLayoutY(500);
        slider.setPrefWidth(200);

        // Bind rotation angle to slider value
        rotateYY.angleProperty().bind(slider.valueProperty());

        //Creating a scene object
        Scene scene = new Scene(new Group(root, slider), 800, 600);
        scene.setFill(Color.web("#81c483"));

        // Mouse interaction to rotate the box
        scene.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                mousePosX = event.getSceneX();
                mousePosY = event.getSceneY();
            }
        });

        scene.setOnMouseDragged(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                double deltaX = event.getSceneX() - mousePosX;
                double deltaY = event.getSceneY() - mousePosY;

                rotateX.setAngle(rotateX.getAngle() - deltaY);
                rotateY.setAngle(rotateY.getAngle() + deltaX);

                mousePosX = event.getSceneX();
                mousePosY = event.getSceneY();
            }
        });

        // Setting title to the Stage
        stage.setTitle("Translate a Box");

        // Adding scene to the stage
        stage.setScene(scene);

        // Displaying the contents of the stage
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}