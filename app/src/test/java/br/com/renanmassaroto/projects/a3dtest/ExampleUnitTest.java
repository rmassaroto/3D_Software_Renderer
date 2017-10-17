package br.com.renanmassaroto.projects.a3dtest;

import org.junit.Test;

import br.com.renanmassaroto.projects.a3dtest.common.model.Point3D;
import br.com.renanmassaroto.projects.a3dtest.common.model.Vertex;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void calculatePoints_isCorrect() throws Exception {
        Vertex vertex = new Vertex(
                new Point3D(0, 0, 0),
                new Point3D(1, 0, 0)
        );

        vertex.calculatePoints();

        assertEquals(2, vertex.points.length);
    }
}