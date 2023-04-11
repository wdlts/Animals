package org.example.Attestation;

public abstract class Animal {
    protected String name;
    protected String command;
    protected String DoB;
    public Animal(String name, String command, String DoB) {
        this.name = name;
        this.command = command;
        this.DoB = DoB;
    }
    protected String getName() {
        return name;
    }
    protected String getCommand() {
        return command;
    }
    protected void setCommand(String command) {
        this.command = command;
    }
    protected abstract void voice();
}
