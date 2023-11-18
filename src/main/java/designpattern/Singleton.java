package designpattern;

public class Singleton {
    private static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getSingleton() {
        if (singleton == null)
            singleton = new Singleton();
        return singleton;
    }

    @Override
    public String toString() {
        return "Singleton{ " + hashCode() + " }";
    }
}
