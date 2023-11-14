package oop.interfaces;

import common.*;

public interface Flyable {
    int MY_SERIAL_NUM = 01;
    // Constant field (implicitly public, static, final)
    int MAX_ALTITUDE = 10000;

    // Abstract method (implicitly public, abstract)
    void fly();

    void colorOfTheSky();

    // Default method with implementation
    default void glide() {
        Logs.println("Glide like a bird");
    }

    // Static method with implementation
    static void takeOff() {
        Logs.println("Taking off for flight");
    }
}
