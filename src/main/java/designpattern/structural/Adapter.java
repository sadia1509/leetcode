package designpattern.structural;

// ADAPTER DESIGN PATTERN

import common.*;

import java.util.*;

interface Student {
    String getName();

    String getEmail();
}

class CollegeStudent implements Student {
    private String name;
    private String email;

    public CollegeStudent(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CollegeStudent{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class SchoolStudent {
    private String name;
    private String email;

    public SchoolStudent(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "SchoolStudent{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class SchoolStudentAdapter implements Student {
    private SchoolStudent schoolStudent;

    public SchoolStudentAdapter(SchoolStudent schoolStudent) {
        this.schoolStudent = schoolStudent;
    }

    @Override
    public String getName() {
        return this.schoolStudent.getName();
    }

    @Override
    public String getEmail() {
        return this.schoolStudent.getEmail();
    }

    @Override
    public String toString() {
        return this.schoolStudent.toString();
    }
}

public class Adapter {
    public static void main() {
        Logs.println("==========( Adapter )==========");
        List<Student> studentList = new LinkedList<>();
        CollegeStudent collegeStudent = new CollegeStudent("Sad", "sad@gmail.com");
        SchoolStudent schoolStudent = new SchoolStudent("Mad", "mad@gmail.com");
        studentList.add(collegeStudent);
        studentList.add(new SchoolStudentAdapter(schoolStudent));
        Logs.println(studentList);
        Logs.lineBreak(1);
    }
}
