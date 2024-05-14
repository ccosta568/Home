package House;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class Roof extends MeshView {
    public Roof(double width, double depth) {
        TriangleMesh roofMesh = new TriangleMesh();

        float[] points = {
                // Bottom vertices
                0, 0, 0,
                (float) width / 2, 0, (float) depth / 2,
                (float) width / 2, 0, (float) -depth / 2,
                (float) -width / 2, 0, (float) -depth / 2,
                (float) -width / 2, 0, (float) depth / 2,
                // Top vertex
                0, (float) -width / 2, 0
        };

        int[] faces = {
                // Base faces
                0, 0, 1, 1, 2, 2,
                0, 0, 2, 2, 3, 3,
                0, 0, 3, 3, 4, 4,
                0, 0, 4, 4, 1, 1,
                // Side faces
                1, 0, 2, 1, 5, 2,
                2, 0, 3, 1, 5, 2,
                3, 0, 4, 1, 5, 2,
                4, 0, 1, 1, 5, 2
        };

        roofMesh.getPoints().setAll(points);
        roofMesh.getTexCoords().addAll(0, 0);
        roofMesh.getFaces().setAll(faces);

        setMesh(roofMesh);
        setMaterial(new PhongMaterial(Color.RED)); // Example material, you can customize
    }
}