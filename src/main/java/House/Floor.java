package House;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Floor {
    private Box floorShape;
    private PhongMaterial material;

    public Floor(double width, double height, double depth, Color color) {
        floorShape = new Box(width, height, depth);
        material = new PhongMaterial(color);
        floorShape.setMaterial(material);
    }

    public Box getFloorShape() {
        return floorShape;
    }

    public void setWidth(double width) {
        floorShape.setWidth(width);
    }

    public void setHeight(double height) {
        floorShape.setHeight(height);
    }

    public void setDepth(double depth) {
        floorShape.setDepth(depth);
    }

    public void setColor(Color color) {
        material.setDiffuseColor(color);
    }
}