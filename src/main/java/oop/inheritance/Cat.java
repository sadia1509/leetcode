package oop.inheritance;

import common.*;

public class Cat extends Animal {
    private String furColor;

    // Constructor calling the superclass constructor
    public Cat(String species, int age, double weight, String furColor) {
        super(species, age, weight);
        this.furColor = furColor;
    }

    // Getter and setter for furColor
    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    // Additional method specific to Cat
    public void meow() {
        Logs.println("Meow! I'm a cat.");
    }

    // Overriding displayInfo method to include fur color
    @Override
    public void info() {
        super.info(); // Call the superclass method
        Logs.println("Fur Color: " + furColor);
    }
}

