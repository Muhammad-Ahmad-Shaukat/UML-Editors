package ClassDiagram;

import com.boota.javaproject.ClassDiagram.Class;
import com.boota.javaproject.ClassDiagram.Generalization;
import com.boota.javaproject.ClassDiagram.Point;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralizationTest {

    private Generalization generalization;
    private Class startClass;
    private Class endClass;

    @BeforeEach
    void setUp() {
        // Create mock classes for testing purposes
        startClass = new Class("StartClass", new Point(10.0,10.0));
        endClass = new Class("EndClass", new Point(10.0,30.0));

        // Initialize the Generalization object
        generalization = new Generalization(startClass, endClass);
    }

    @AfterEach
    void tearDown() {
        // Clean up after each test
        generalization = null;
        startClass = null;
        endClass = null;
    }

    @Test
    void getStartClass() {
        assertEquals(startClass, generalization.getStartClass(), "Start class should match the initialized value.");
    }

    @Test
    void getEndClass() {
        assertEquals(endClass, generalization.getEndClass(), "End class should match the initialized value.");
    }

    @Test
    void setEndClass() {
        // Change end class
        Class newEndClass = new Class("NewEndClass", new Point(10.0,50.0));
        generalization.setEndClass(newEndClass);

        assertEquals(newEndClass, generalization.getEndClass(), "End class should be updated correctly.");
    }

    @Test
    void setStartClass() {
        // Change start class
        Class newStartClass = new Class("NewStartClass", new Point(10.0,90.0));
        generalization.setStartClass(newStartClass);

        assertEquals(newStartClass, generalization.getStartClass(), "Start class should be updated correctly.");
    }
}
