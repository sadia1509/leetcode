package designpattern.creational;

import common.*;

// FACTORY DESIGN PATTERN
interface Employee {
    int salary();
}

class Engineers implements Employee {
    Engineers() {
        Logs.println("Engineer Type is Selected!");
    }

    @Override
    public int salary() {
        return 50000;
    }
}

class HRs implements Employee {
    HRs() {
        Logs.println("HR Type is Selected!");
    }

    @Override
    public int salary() {
        return 30000;
    }
}

class EmployeeFactory {
    public static Employee getEmployee(String type) {
        switch (type.toUpperCase()) {
            case "ENGINEER":
                return new Engineers();
            case "HR":
                return new HRs();
        }
        return null;
    }
}

public class Factory {
    public static void main() {
        Logs.println("==========( Factory )==========");
        // Displaying the salary based on employee type!
        Employee employee = EmployeeFactory.getEmployee("engineer");
        if (employee == null) Logs.println("No such type exists!!!");
        else Logs.println("salary : " + employee.salary());
        Logs.lineBreak(1);
    }
}
