package House;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Base extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a 3D box
        Box box = new Box();
        box.setWidth(200.0);
        box.setHeight(400.0);
        box.setDepth(200.0);

        // Create a group and add the box to it
        Group root = new Group(box);



    }

    public static void main(String[] args) {
        launch(args);
    }
}