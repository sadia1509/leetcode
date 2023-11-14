package oop.abstraction;

public class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
        this.area = calculateArea(); // Calculate and set the area during construction
    }

    // Implementation of calculateArea for Rectangle
    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double randomArea() {
        return 0;
    }

    @Override
    public String toString() {
        return "Rectangle - Length: " + length + ", Width: " + width;
    }
}