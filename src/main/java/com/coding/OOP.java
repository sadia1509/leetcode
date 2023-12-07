package com.coding;

import common.*;
import oop.abstraction.*;
import oop.composition.*;
import oop.enumeration.*;
import oop.inheritance.*;
import oop.interfaces.*;
import oop.tool.ComparatorClass;

import java.util.Arrays;

public class OOP {
    public static void run() {
        /* Inheritance */
//        // Creating instances using different constructors
//        Animal animal1 = new Animal();
//        Animal animal2 = new Animal("Dog", 3, 7.5);
//        Animal animal3 = new Animal("Cat", 2.5);
//        // Displaying information\
//        animal1.info();
//        animal2.info();
//        animal3.info();
//
//        // Creating an instance of the Cat class
//        Cat myCat = new Cat("Persian Cat", 3, 4.5, "White");
//        // Displaying information
//        myCat.info();
//        myCat.meow(); // Specific method for Cat
//
//        // Creating an instance of the Tom class
//        Tom tomCat = new Tom(5, 7.0, "Grey");
//        // Displaying information
//        tomCat.info();
//        tomCat.meow(); // Inherited from Cat
//        tomCat.catchJerry(); // Specific to Tom



        /* Abstraction */
//        // Creating instances of Circle and Rectangle
//        Circle circle = new Circle(5.0);
//        Rectangle rectangle = new Rectangle(4.0, 6.0);
//        Triangle triangle = new Triangle(3.0, 4.0);
//        // Displaying information about each shape
//        circle.info();
//        rectangle.info();
//        triangle.info();
//        Logs.println(circle);
//        Logs.println(rectangle);



        /* Interface */
//        // Accessing constant fields and static methods through interfaces
//        Logs.println("Max Altitude: " + Flyable.MAX_ALTITUDE);
//        Flyable.takeOff();
//        Logs.println("Water Type: " + SwimAble.WATER_TYPE);
//        SwimAble.dive();
//        // Creating an instance of FlyingFish
//        FlyingFish flyingFish = new FlyingFish();
//        // Calling methods from both interfaces
//        flyingFish.fly();
//        flyingFish.swim();
//        // Calling default and static methods from interfaces
//        flyingFish.glide();
//        flyingFish.floatOnWater();
//        // Logs.println(flyingFish.MY_SERIAL_NUM);   -> (not possible)


        /* Composition */
//        // Creating a Car
//        Car myCar = new Car();
//        // Starting the Car, which internally starts the Engine
//        myCar.start();

        /* Enum */
//        // Accessing enum constants
//        Cards hearts = Cards.HEARTS;
//        Cards diamonds = Cards.DIAMONDS;
//        // Accessing fields and calling methods
//        Logs.println("Hearts: " + hearts.getDisplayName() + ", Color: " + hearts.getColor());
//        Logs.println("Diamonds: " + diamonds.getDisplayName() + ", Color: " + diamonds.getColor());
//        // Enum iteration
//        Logs.println("All Suits:");
//        for (Cards card : Cards.values())
//            Logs.println(card.getDisplayName() + " - " + card.getColor());
//        // Switch statement with enum
//        Cards randomSuit = Cards.CLUBS; // Assume some logic to get a random suit
//        switch (randomSuit) {
//            case HEARTS:
//                Logs.println("It's a heart!");
//                break;
//            case DIAMONDS:
//                Logs.println("It's a diamond!");
//                break;
//            case CLUBS:
//                Logs.println("It's a club!");
//                break;
//            case SPADES:
//                Logs.println("It's a spade!");
//                break;
//        }

        /* Tools */
        ComparatorClass comparatorClass = new ComparatorClass();
//        comparatorClass.sortByStringLength(Arrays.asList("sadia", "sam", "i", "ok"));
//        comparatorClass.sortTheStudentsMarks();
//        comparatorClass.sortTheStudentNames();
    }
}
