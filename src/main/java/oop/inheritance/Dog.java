package oop.inheritance;

import common.*;

public class Dog {
    public class Cat extends Animal {
        private String furSize;

        // Constructor calling the superclass constructor
        public Cat(String species, int age, double weight, String furSize) {
            super(species, age, weight);
            this.furSize = furSize;
        }

        // Getter and setter for furColor
        public String getFurSize() {
            return furSize;
        }

        public void setFurColor(String furSize) {
            this.furSize = furSize;
        }

        // Additional method specific to Cat
        public void bark() {
            Logs.println("Woof! I'm a dog.");
        }

        // Overriding displayInfo method to include fur color
        @Override
        public void info() {
            super.info(); // Call the superclass method
            Logs.println("Fur Color: " + furSize);
        }
    }
}
