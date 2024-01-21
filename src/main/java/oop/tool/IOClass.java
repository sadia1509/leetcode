package oop.tool;

import common.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class IOClass {
    // taking input from users
    public void inputPrinter() {
        Scanner sc = new Scanner(System.in);
        Logs.print("Please write your full name: ");
        String fullName = sc.nextLine();
        Logs.print("and your age: ");
        int age = sc.nextInt();
        Logs.println("Full Name: " + fullName + "\n" + "Age: " + age);
    }

    // Read a text file
    public void readTextFile() {
        try {
            Path filePath = Paths.get("src/main/resources/IOClassFile.txt");
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                Logs.println(line);
            }
        } catch (IOException e) {
            Logs.println(e);
        }
    }

    // Write a text file
    public void writeTextFile() {
        try {
            Path filePath = Paths.get("src/main/resources/IOClassFile.txt");
            List<String> lines = Arrays.asList("I am good!");
            Files.write(filePath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
