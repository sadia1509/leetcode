package oop.abstraction;

import common.*;

// Abstract class Shape
abstract class Shape {
    // Static variable shared by all shapes
    private static int totalShapes = 0;

    // Instance variables
    protected double area; // Can be accessed by subclasses
    private final String name; // Final variable for the name of the shape

    // Constructor
    public Shape(String name) {
        this.name = name;
        totalShapes++;
    }

    // Static method to get the total number of shapes
    public static int getTotalShapes() {
        return totalShapes;
    }

    // Abstract method to calculate area
    public abstract double calculateArea();
    public abstract double randomArea();

    // Non-abstract method to display information about the shape
    public void info() {
        Logs.println("Information: ");
    }

    // Non-abstract method with final keyword
    public final void printTotalShapes() {
        Logs.println("Total Shapes: " + totalShapes);
    }
}




