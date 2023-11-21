package designpattern.behavioral;

import common.*;

import java.text.DecimalFormat;

// VISITOR DESIGN PATTERN
// Visitor interface
interface Visitors {
    void visit(Circle circle);

    void visit(Square square);
}

// Element interface
interface Shape {
    void accept(Visitors visitor);
}

// Concrete Element
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(Visitors visitor) {
        visitor.visit(this);
    }
}

// Concrete Element
class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public void accept(Visitors visitor) {
        visitor.visit(this);
    }
}

// Concrete Visitor
class AreaCalculator implements Visitors {
    double totalArea = 0;
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public void visit(Circle circle) {
        double area = Math.PI * Math.pow(circle.getRadius(), 2);
        Logs.println("Area of Circle: " + Double.parseDouble(df.format(area)));
        totalArea += area;
    }

    @Override
    public void visit(Square square) {
        double area = Math.pow(square.getSide(), 2);
        Logs.println("Area of Square: " + Double.parseDouble(df.format(area)));
        totalArea += area;
    }

    public double getTotalArea() {
        return Double.parseDouble(df.format(totalArea));
    }
}


public class Visitor {
    public static void main() {
        Logs.println("==========( Visitor )==========");
        Circle circle = new Circle(5);
        Square square = new Square(4);
        AreaCalculator areaCalculator = new AreaCalculator();
        circle.accept(areaCalculator);
        square.accept(areaCalculator);
        Logs.println("Total area: " + areaCalculator.getTotalArea());
        Logs.lineBreak(1);
    }
}
