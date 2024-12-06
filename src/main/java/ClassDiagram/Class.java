package ClassDiagram;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable {
    String className;
    ArrayList<Attribute> attributes;
    ArrayList<Function> functions;
    Point initialPoint;
    ArrayList<Class> InheritedClasses;

    public Class(String className, Point initialPoint) {
        this.className = className;
        this.initialPoint = initialPoint;
        attributes = new ArrayList<>();
        functions = new ArrayList<>();
    }

    public Class(Point initialPoint) {
        this.initialPoint = initialPoint;
        attributes = new ArrayList<>();
        functions = new ArrayList<>();
        className = "Class";
    }

    public Class(String className, ArrayList<Attribute> attributes, ArrayList<Function> functions, Point initialPoint) {
        this.className = className;
        this.attributes = attributes;
        this.functions = functions;
        this.initialPoint = initialPoint;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    public ArrayList<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(ArrayList<Function> functions) {
        this.functions = functions;
    }

    public Point getInitialPoint() {
        return initialPoint;
    }

    public void setInitialPoint(Point initialPoint) {
        this.initialPoint = initialPoint;
    }

    void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    void addFunction(Function function) {
        functions.add(function);
    }

    void removeFunction(Function function) {
        functions.remove(function);
    }

    void removeAttribute(Attribute attribute) {
        attributes.remove(attribute);
    }

    String returnAttribute() {
        StringBuilder result = new StringBuilder();
        for (Attribute attribute : attributes) {
            result.append(attribute.toString()).append("\n");
        }
        return result.toString();
    }

    String returnFunction() {
        StringBuilder result = new StringBuilder();
        for (Function function : functions) {
            result.append(function.toString()).append("\n");
        }
        return result.toString();
    }
    public void generateCode(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write class declaration
            writer.write("public class " + className + " {\n");

            // Write attributes
            for (Attribute attribute : attributes) {
                writer.write("    " + attribute.generateCode() + "\n");
            }

            // Write functions
            for (Function function : functions) {
                writer.write("    " + function.generateCode() + "\n");
            }

            writer.write("}\n"); // Close the class

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
