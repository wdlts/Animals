package org.example.Attestation.Animals;
import org.example.Attestation.PackAnimal;
public class Donkey extends PackAnimal {
    static int count;
    public Donkey(String name, String command, String dateOfBirth) {
        super(name, command, dateOfBirth);
        count++;
    }
    @Override
    public void voice() {
        System.out.println("Иа!");
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
        return  "Имя осла " + count + " = " + name +
                ", комманда = " + command +
                ", дата рождения = " + DoB + "\n";
    }
}
