package designpattern.structural;

import common.*;

import java.util.*;

// COMPOSITE DESIGN PATTERN
// Component interface
interface Graphic {
    void draw();
}

// Leaf component
class RoundShape implements Graphic {
    private String name;

    public RoundShape(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        Logs.println("Drawing Circle: " + name);
    }
}

// Composite component
class CompositeGraphic implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    @Override
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}

public class Composite {
    public static void main() {
        Logs.println("==========( Composite )==========");
        // Creating leaf components
        RoundShape circle1 = new RoundShape("Red Circle");
        RoundShape circle2 = new RoundShape("Blue Circle");
        // Creating composite component
        CompositeGraphic compositeGraphic = new CompositeGraphic();
        compositeGraphic.add(circle1);
        compositeGraphic.add(circle2);
        // Drawing individual circles
        Logs.println("Drawing individual circles:");
        circle1.draw();
        circle2.draw();
        // Drawing composite graphic (which includes circles)
        Logs.println("\nDrawing composite graphic:");
        compositeGraphic.draw();
        Logs.lineBreak(1);
    }
}
