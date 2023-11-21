package designpattern.behavioral;

import common.*;

// COMMAND DESIGN PATTERN
// Command interface
interface Commands {
    void execute();
}

// Concrete command
class LightOnCommand implements Commands {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete command
class LightOffCommand implements Commands {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Receiver
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Invoker
class RemoteControl {
    private Commands command;

    public void setCommand(Commands command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}


public class Command {
    public static void main() {
        Logs.println("==========( Command )==========");
        Light light = new Light();
        // Creating command objects
        Commands lightOnCommand = new LightOnCommand(light);
        Commands lightOffCommand = new LightOffCommand(light);
        // Creating invoker
        RemoteControl remote = new RemoteControl();
        // Setting commands to invoker
        remote.setCommand(lightOnCommand);
        // Pressing the button
        remote.pressButton();
        // Changing the command
        remote.setCommand(lightOffCommand);
        // Pressing the button again
        remote.pressButton();
        Logs.lineBreak(1);
    }
}
