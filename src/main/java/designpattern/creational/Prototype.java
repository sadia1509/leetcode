package designpattern.creational;

import common.*;

import java.util.*;

// PROTOTYPE DESIGN PATTERN
class DBConnection implements Cloneable {
    private String username;
    private String password;

    private List<String> tables;

    public DBConnection(String username, String password) {
        this.username = username;
        this.password = password;
        this.tables = new LinkedList<>();
    }

    public void loadTheTables() {
        tables.add("Employees");
        tables.add("Offices");
        tables.add("Departments");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getTables() {
        return this.tables;
    }

    @Override
    public String toString() {
        return "DBConnection{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tables=" + tables +
                '}';
    }

    @Override
    protected DBConnection clone() {
        // Deep cloning
        DBConnection clone = new DBConnection(username, password);
        clone.tables = new ArrayList<>(this.tables);
        return clone;
//        // Shallow cloning
//        try {
//            return (DBConnection) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }
    }
}


// Client code
public class Prototype {
    public static void main() {
        Logs.println("==========( Prototype )==========");
        DBConnection dbConnection = new DBConnection("sadia", "123");
        dbConnection.loadTheTables();
        DBConnection dbConnection1 = dbConnection.clone();
        DBConnection dbConnection2 = dbConnection.clone();
        dbConnection.getTables().add("Stuff");
        dbConnection1.getTables().remove(0);
        Logs.println(dbConnection);
        Logs.println(dbConnection1);
        Logs.println(dbConnection2);
        Logs.lineBreak(1);
    }
}

