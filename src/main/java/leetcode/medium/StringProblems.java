package leetcode.medium;

import java.math.BigInteger;

public class StringProblems {
    //Multiply Strings
    public String multiply(String num1, String num2) {
        BigInteger num1B = new BigInteger(num1);
        BigInteger num2B = new BigInteger(num2);
        return num1B.multiply(num2B).toString();
    }
}
