package designpattern.creational;


import common.*;

// SINGLETON DESIGN PATTERN
class SingletonClass {
    private static SingletonClass singleton;

    private SingletonClass() {

    }

    public static SingletonClass getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) { // To make thread-safe
                singleton = new SingletonClass();
            }
        }
        return singleton;
    }

    @Override
    public String toString() {
        return "Singleton{ " + hashCode() + " }";
    }
}

public class Singleton {
    public static void main() {
        Logs.println("==========( Singleton )==========");
        SingletonClass singleton = SingletonClass.getSingleton();
        Logs.println("First call : " + singleton);
        singleton = SingletonClass.getSingleton();
        Logs.println("Second call : " + singleton);
        Logs.lineBreak(1);
    }
}