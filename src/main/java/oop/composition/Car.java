package oop.composition;

import common.*;

public class Car { // Car class (using composition to include an Engine)
    // Composition: Car has an Engine
    private Engine engine;

    // Constructor initializing the Engine
    public Car() {
        this.engine = new Engine();
    }

    public void start() {
        Logs.println("Car starting...");
        // Delegating the start operation to the Engine
        engine.start();
    }
}
