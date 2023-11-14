package oop.abstraction;

public class Triangle extends Shape {
    private double base;
    private double height;

    // Constructor
    public Triangle(double base, double height) {
        super("Triangle");
        this.base = base;
        this.height = height;
        this.area = calculateArea(); // Calculate and set the area during construction
    }

    // Implementation of calculateArea for Triangle
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public double randomArea() {
        return 0;
    }
}
