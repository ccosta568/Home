package House;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Base extends Application {

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

        // Creating a roof for the house using Roof class
        Roof roof = new Roof();

        //Creating a Group object
        Group root = new Group(box, roof.getRoof());

        //Creating a scene object
        Scene scene = new Scene(new Group(root), 800, 600);
        scene.setFill(Color.web("#81c483"));

        // Setting title to the Stage
        stage.setTitle("Translate a Box");

        // Adding scene to the stage
        stage.setScene(scene);

        // Displaying the contents of the stage
        stage.show();

        // Create rotation control
        Rotation.Rotation.setupRotation(box, root, scene);

    }

    public static void main(String args[]) {
        launch(args);
    }
}