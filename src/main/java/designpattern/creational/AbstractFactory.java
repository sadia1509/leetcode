package designpattern.creational;

import common.*;

// ABSTRACT FACTORY DESIGN PATTERN
// Abstract Product A
interface Chair {
    void sitOn();
}

// Concrete Product A1
class ModernChair implements Chair {
    @Override
    public void sitOn() {
        Logs.println("Sitting on a modern chair.");
    }
}

// Concrete Product A2
class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        Logs.println("Sitting on a Victorian chair.");
    }
}

// Abstract Product B
interface Table {
    void putOn();
}

// Concrete Product B1
class ModernTable implements Table {
    @Override
    public void putOn() {
        Logs.println("Putting on a modern table.");
    }
}

// Concrete Product B2
class VictorianTable implements Table {
    @Override
    public void putOn() {
        Logs.println("Putting on a Victorian table.");
    }
}

// Abstract Factory
interface FurnitureFactory {
    Chair createChair();
    Table createTable();
}

// Concrete Factory 1
class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}

// Concrete Factory 2
class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
}

// Client code
public class AbstractFactory {
    public static void main() {
        Logs.println("==========( Abstract Factory )==========");
        // Using the abstract factory to create a family of related products
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        Table modernTable = modernFactory.createTable();
        modernChair.sitOn();
        modernTable.putOn();
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        Chair victorianChair = victorianFactory.createChair();
        Table victorianTable = victorianFactory.createTable();
        victorianChair.sitOn();
        victorianTable.putOn();
        Logs.lineBreak(1);
    }
}
