package common;

import java.util.Arrays;

public class Utils {
    public static GenericUtils<Object> Object() {
        return new GenericUtils<Object>();
    }

    public static GenericUtils<Character> Character() {
        return new GenericUtils<Character>();
    }

    public static GenericUtils<Integer> Integer() {
        return new GenericUtils<Integer>();
    }

    public static GenericUtils<String> String() {
        return new GenericUtils<String>();
    }

    public static Integer[] intToInteger(int[] array) {
        Integer[] integerArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
        return integerArray;
    }

    public static Integer[][] intToInteger(int[][] array) {
        Integer[][] integerArray = Arrays.stream(array)
                .map(row -> Arrays.stream(row).boxed().toArray(Integer[]::new))
                .toArray(Integer[][]::new);
        return integerArray;
    }
}
