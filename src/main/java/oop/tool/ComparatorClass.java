package oop.tool;

import common.*;

import java.util.*;

public class ComparatorClass {
    // Anonymous class of comparator interface
    Comparator<String> smallToLargeComparator = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            if (s1.length() > s2.length()) return 1;
            else return -1;
        }
    };

    // Comparator implementation with lambda expression
    Comparator<String> largeToSmallComparator = (s1, s2) -> s1.length() < s2.length() ? 1 : -1;

    public void sortByStringLength(List<String> list) {
        Collections.sort(list, smallToLargeComparator);
        Logs.println(list);
        Collections.sort(list, largeToSmallComparator);
        Logs.println(list);
    }

    private List<StudentsUsingComparable> getStudentList() {
        List<StudentsUsingComparable> list = new LinkedList<>();
        list.add(new StudentsUsingComparable("pam", 8.34));
        list.add(new StudentsUsingComparable("sam", 20.34));
        list.add(new StudentsUsingComparable("jam", 10.34));
        list.add(new StudentsUsingComparable("tam", 5.34));
        list.add(new StudentsUsingComparable("bam", 5.34));
        list.add(new StudentsUsingComparable("bam", 1.34));
        list.add(new StudentsUsingComparable("zam", 5.34));
        return list;
    }

    public void sortTheStudentsMarks() {
        List<StudentsUsingComparable> studentList = getStudentList();
        Collections.sort(studentList);
        Logs.println(studentList);
        Collections.sort(studentList, new SortMarksThenNames());
        Logs.println(studentList);
    }

    public void sortTheStudentNames() {
        List<StudentsUsingComparable> studentList = getStudentList();
        Collections.sort(studentList, Comparator.comparing(s -> s.name));
        Logs.println(studentList);
        Collections.sort(studentList, Comparator.comparing(StudentsUsingComparable::getName).reversed());
        Logs.println(studentList);
        Collections.sort(studentList, (s1, s2) -> { // SortNamesThenMarks
            if (s1.name.equals(s2.name))
                return (int) (s1.marks - s2.marks);
            else return s1.name.compareTo(s2.name);
        });
        Logs.println(studentList);
    }
}

class StudentsUsingComparable implements Comparable<StudentsUsingComparable> {
    String name;
    double marks;

    StudentsUsingComparable(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(StudentsUsingComparable that) {
        return this.marks > that.marks ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}

class SortMarksThenNames implements Comparator<StudentsUsingComparable> {
    @Override
    public int compare(StudentsUsingComparable s1, StudentsUsingComparable s2) {
        if (s1.marks == s2.marks)
            return s1.name.compareTo(s2.name);
        else return (int) (s1.marks - s2.marks);
    }
}