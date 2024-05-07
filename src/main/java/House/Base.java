package House;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Base extends Application {

    @Override
    public void start(Stage stage) {
        //Drawing a Box
        Box box = new Box();

        //Setting the properties of the Box
        box.setWidth(200.0);
        box.setHeight(200.0);
        box.setDepth(200.0);

        Translate translate = new Translate();
        translate.setX(200);
        translate.setY(150);
        translate.setZ(25);

        box.getTransforms().addAll(translate);

        // Rotate the box
        Rotate rotateX = new Rotate(45, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(45, Rotate.Y_AXIS);
        box.getTransforms().addAll(translate, rotateX, rotateY);

        //Creating a Group object
        Group root = new Group(box);

        //Creating a scene object
        Scene scene = new Scene(root, 800, 600);

        scene.setFill(Color.web("#81c483"));


        //Setting title to the Stage
        stage.setTitle("Translate a Box");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
