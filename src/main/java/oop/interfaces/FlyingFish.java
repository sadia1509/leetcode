package oop.interfaces;

import common.*;

public class FlyingFish implements Flyable, SwimAble {
    @Override
    public void fly() {
        Logs.println("Flying Fish can fly!");
    }

    @Override
    public void colorOfTheSky() {
        Logs.println("Right now it is blue!");
    }

    @Override
    public void swim() {
        Logs.println("Flying Fish can also swim!");
    }
}
