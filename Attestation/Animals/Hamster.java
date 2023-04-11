package org.example.Attestation.Animals;
import org.example.Attestation.Pet;
public class Hamster extends Pet {
    static int count;
    public Hamster(String name, String command, String dateOfBirth) {
        super(name, command, dateOfBirth);
        count++;
    }
    @Override
    public void voice() {
        System.out.println("Кукареку");
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
        return  "Имя хомяка " + count + " = " + name +
                ", комманда = " + command +
                ", дата рождения = " + DoB + "\n";
    }
}
