package oop.inheritance;

import common.*;

public class Animal {
    private String species;
    private int age;
    private double weight;

    // Default constructor
    public Animal() {
        this.species = "Unknown";
        this.age = 0;
        this.weight = 0.0;
    }

    // Parameterized constructor with species, age, and weight
    public Animal(String species, int age, double weight) {
        this.species = species;
        this.age = age;
        this.weight = weight;
    }

    // Parameterized constructor with species and weight
    public Animal(String species, double weight) {
        this.species = species;
        this.age = 0; // Default age
        this.weight = weight;
    }

    // Getter methods
    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    // Setter methods
    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void info() {
        Logs.println("Weight: " + weight + " kg");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}

