package oop.inheritance;

import common.*;

public class Tom extends Cat {

    // Constructor calling the superclass constructor
    public Tom(int age, double weight, String furColor) {
        super("Domestic Cat", age, weight, furColor);
    }

    // Additional method specific to Tom
    public void catchJerry() {
        Logs.println("Tom is trying to catch Jerry!");
    }

    // Overriding displayInfo method
    @Override
    public void info() {
        super.info(); // Call the superclass method
        Logs.println("Tom's Special Trait: Can catch Jerry!");
    }
}

