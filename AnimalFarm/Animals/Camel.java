package org.example.AnimalFarm.Animals;

import org.example.AnimalFarm.PackAnimal;
public class Camel extends PackAnimal {
    static int count;
    public Camel(String name, String command, String dateOfBirth) {
        super(name, command, dateOfBirth);
        count++;
    }
    @Override
    public void voice() {
        System.out.println("Фу!");
    }
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public String getCommand() {
        return super.getCommand();
    }
    @Override
    public void setCommand(String command) {
        super.setCommand(command);
    }
    @Override
    public String toString() {
        return  "Имя верблюда " + count + " = " + name +
                ", комманда = " + command +
                ", дата рождения = " + DoB + "\n";
    }
}
