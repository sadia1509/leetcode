package designpattern.structural;

import common.*;

// DECORATOR DESIGN PATTERN
// Component interface
interface Coffee {
    double cost();
}

// Concrete component
class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 2.0; // Base cost of a simple coffee
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}

// Concrete decorator
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.5; // Additional cost for milk
    }
}

// Concrete decorator
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.2; // Additional cost for sugar
    }
}

public class Decorator {
    public static void main() {
        Logs.println("==========( Decorator )==========");
        Coffee simpleCoffee = new SimpleCoffee();
        Logs.println("Cost of simple coffee: $" + simpleCoffee.cost());
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        Logs.println("Cost of milk coffee: $" + milkCoffee.cost());
        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        Logs.println("Cost of sugar and milk coffee: $" + sugarMilkCoffee.cost());
        Logs.lineBreak(1);
    }
}
