package common;

public class Logs {

    public static void lineBreak(int times) {
        for (int i = 0; i < times; i++) System.out.println();
    }

    public static void print(Object object) {
        System.out.print(object);
    }

    public static void println(Object object) {
        System.out.println(object);
    }
}
