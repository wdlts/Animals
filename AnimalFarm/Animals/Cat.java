package org.example.AnimalFarm.Animals;

import org.example.AnimalFarm.Pet;
public class Cat extends Pet {
    static int count;
    public Cat(String name, String command, String dateOfBirth) {
        super(name, command, dateOfBirth);
        count++;
    }
    @Override
    public void voice() {
        System.out.println("Мяу!");
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
        return  "Имя кота " + count + " = " + name +
                ", комманда = " + command +
                ", дата рождения = " + DoB + "\n";
    }
}
