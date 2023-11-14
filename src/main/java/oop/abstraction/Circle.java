package oop.abstraction;

public class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
        this.area = calculateArea(); // Calculate and set the area during construction
    }

    // Implementation of calculateArea for Circle
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double randomArea() {
        return 0;
    }

    // toString method to display information about the Circle
    @Override
    public String toString() {
        return "Circle - Radius: " + radius;
    }
}
