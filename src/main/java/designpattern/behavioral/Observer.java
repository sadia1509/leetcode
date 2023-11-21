package designpattern.behavioral;

import common.*;

import java.util.*;

// OBSERVER DESIGN PATTERN
// Observer interface
interface Observers {
    void update(String message);
}

// Subject interface
interface Subject {
    void addObserver(Observers observer);

    void removeObserver(Observers observer);

    void notifyObservers();
}

// Concrete subject
class ConcreteSubject implements Subject {
    private List<Observers> observers = new ArrayList<>();
    private String state;

    @Override
    public void addObserver(Observers observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observers observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observers observer : observers) {
            observer.update(state);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}

// Concrete observer
class ConcreteObserver implements Observers {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        Logs.println(name + " received an update: " + message);
    }
}

public class Observer {
    public static void main() {
        Logs.println("==========( Observer )==========");
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver("Observer 1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2");
        ConcreteObserver observer3 = new ConcreteObserver("Observer 3");
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.addObserver(observer3);
        subject.setState("New state for the subject");
        subject.setState("another New state for the subject");
        Logs.lineBreak(1);
    }
}
