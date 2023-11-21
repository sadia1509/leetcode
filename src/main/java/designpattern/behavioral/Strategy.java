package designpattern.behavioral;

import common.*;

// STRATEGY DESIGN PATTERN
interface OperationStrategy {
    int doOperation(int num1, int num2);
}

class OperationsAdd implements OperationStrategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationsSub implements OperationStrategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationsMul implements OperationStrategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

class OperationsDiv implements OperationStrategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 / num2;
    }
}

class Context {
    private OperationStrategy strategy;

    public Context(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public OperationStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}

public class Strategy {
    public static void main() {
        Logs.println("==========( Strategy )==========");
        Context context = new Context(new OperationsAdd());
        Logs.println("Addition : " + context.executeStrategy(4, 6));
        context = new Context(new OperationsSub());
        Logs.println("Subtraction : " + context.executeStrategy(6, 4));
        context = new Context(new OperationsMul());
        Logs.println("Multiplication : " + context.executeStrategy(4, 6));
        context = new Context(new OperationsDiv());
        Logs.println("Division : " + context.executeStrategy(6, 2));
        Logs.lineBreak(1);
    }
}
