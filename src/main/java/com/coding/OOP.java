package com.coding;

import common.*;
import oop.abstraction.*;
import oop.composition.*;
import oop.inheritance.*;
import oop.interfaces.*;

public class OOP {
    public static void run() {
        /* Inheritance */
        // Creating instances using different constructors
        Animal animal1 = new Animal();
        Animal animal2 = new Animal("Dog", 3, 7.5);
        Animal animal3 = new Animal("Cat", 2.5);
        // Displaying information\
        animal1.info();
        animal2.info();
        animal3.info();

        // Creating an instance of the Cat class
        Cat myCat = new Cat("Persian Cat", 3, 4.5, "White");
        // Displaying information
        myCat.info();
        myCat.meow(); // Specific method for Cat

        // Creating an instance of the Tom class
        Tom tomCat = new Tom(5, 7.0, "Grey");
        // Displaying information
        tomCat.info();
        tomCat.meow(); // Inherited from Cat
        tomCat.catchJerry(); // Specific to Tom



        /* Abstraction */
        // Creating instances of Circle and Rectangle
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        Triangle triangle = new Triangle(3.0, 4.0);
        // Displaying information about each shape
        circle.info();
        rectangle.info();
        triangle.info();
        Logs.println(circle);
        Logs.println(rectangle);



        /* Interface */
        // Accessing constant fields and static methods through interfaces
        Logs.println("Max Altitude: " + Flyable.MAX_ALTITUDE);
        Flyable.takeOff();
        Logs.println("Water Type: " + SwimAble.WATER_TYPE);
        SwimAble.dive();
        // Creating an instance of FlyingFish
        FlyingFish flyingFish = new FlyingFish();
        // Calling methods from both interfaces
        flyingFish.fly();
        flyingFish.swim();
        // Calling default and static methods from interfaces
        flyingFish.glide();
        flyingFish.floatOnWater();


        /* Composition */
        // Creating a Car
        Car myCar = new Car();
        // Starting the Car, which internally starts the Engine
        myCar.start();
    }
}
