package oop.interfaces;

import common.Logs;

public interface SwimAble {
    int MY_SERIAL_NUM = 02;
    // Constant field
    String WATER_TYPE = "Saltwater";

    // Abstract method
    void swim();

    // Default method with implementation
    default void floatOnWater() {
        Logs.println("Floating on the water surface");
    }

    // Static method with implementation
    static void dive() {
        Logs.println("Diving into the water");
    }
}
