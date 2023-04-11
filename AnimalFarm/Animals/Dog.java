package org.example.AnimalFarm.Animals;
import org.example.AnimalFarm.Pet;
public class Dog extends Pet {
    static int count;
    public Dog(String name, String command, String dateOfBirth) {
        super(name, command, dateOfBirth);
        count++;
    }
    @Override
    public void voice() {
        System.out.println("Вуф!");
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
        return  "Имя собаки " + count + " = " + name +
                ", комманда = " + command +
                ", дата рождения = " + DoB + "\n";
    }
}
