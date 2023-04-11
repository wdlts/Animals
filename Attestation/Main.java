package org.example.Attestation;

import org.example.Attestation.Animals.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void voiceAndPrint(ArrayList<? extends Animal> animals) throws InterruptedException {
        animals.get(0).voice();
        Thread.sleep(500);
        System.out.println(animals.toString().replace("[", "").replace("]", ""));
    }


    public static void getAnimalCommand(ArrayList<? extends Animal> animals, String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name))
                System.out.println("Команда животного " + name + " - " + animal.getCommand());
        }
    }

    public static void setAnimalCommand(ArrayList<? extends Animal> animals, String name, String command) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name))
                animal.setCommand(command);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Вас приветствует питомник животных!");
        Thread.sleep(1500);
        boolean exit = false;
        ArrayList<Dog> dogs = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Hamster> hamsters = new ArrayList<>();
        ArrayList<Horse> horses = new ArrayList<>();
        ArrayList<Camel> camels = new ArrayList<>();
        ArrayList<Donkey> donkeys = new ArrayList<>();
        while (!exit) {
            //Верхний уровень меню начало
            System.out.println();
            System.out.println("Добавить новое животное – введите «1»");
            System.out.println("Вывести список команд животного – введите «2»");
            System.out.println("Обучить животное новой команде – введите «3»");
            System.out.println("Завершить программу – введите «0»");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 0) {
                    System.out.println("Программа завершена.");
                    exit = true;
                } else if (choice < 0 || choice > 3) {
                    System.out.println("Введите правильную цифру");
                } else {
                    switch (choice) {
                        case (1):
                            System.out.println("Добавить новую собаку – введите «1»");
                            System.out.println("Добавить новую кошку – введите «2»");
                            System.out.println("Добавить нового хомяка – введите «3»");
                            System.out.println("Добавить новую лошадь – введите «4»");
                            System.out.println("Добавить нового верблюда – введите «5»");
                            System.out.println("Добавить нового осла – введите «6»");
                            System.out.println("Вернуться в предыдущее меню – введите «0»");
                            scanner = new Scanner(System.in);
                            if (scanner.hasNextInt()) {
                                choice = scanner.nextInt();
                                if (choice == 0) {
                                    break;
                                } else if (choice < 0 || choice > 6) {
                                    System.out.println("Введите правильную цифру");
                                    break;
                                } else {
                                    System.out.println();
                                    Scanner scanner2 = new Scanner(System.in);
                                    System.out.println("Введите имя животного");
                                    String name = scanner2.nextLine();
                                    System.out.println("Введите комманду животного");
                                    String command = scanner2.nextLine();
                                    System.out.println("Введите дату рождения животного в формате 'дд.мм.гггг'");
                                    String dateOfBirth = scanner2.nextLine();
                                    switch (choice) {
                                        case (1):
                                            dogs.add(new Dog(name, command, dateOfBirth));
                                            voiceAndPrint(dogs);
                                            break;
                                        case (2):
                                            cats.add(new Cat(name, command, dateOfBirth));
                                            voiceAndPrint(cats);
                                            break;
                                        case (3):
                                            hamsters.add(new Hamster(name, command, dateOfBirth));
                                            voiceAndPrint(hamsters);
                                            break;
                                        case (4):
                                            horses.add(new Horse(name, command, dateOfBirth));
                                            voiceAndPrint(horses);
                                            break;
                                        case (5):
                                            camels.add(new Camel(name, command, dateOfBirth));
                                            voiceAndPrint(camels);
                                            break;
                                        case (6):
                                            donkeys.add(new Donkey(name, command, dateOfBirth));
                                            voiceAndPrint(donkeys);
                                            break;
                                    }
                                    break;
                                }
                            } else {
                                System.out.println("Введите целое число");
                                System.out.println();
                                break;
                            }
                        case (2):
                            System.out.println();
                            Scanner scanner3 = new Scanner(System.in);
                            System.out.println("Введите имя животного");
                            String name = scanner3.nextLine();
                            getAnimalCommand(cats, name);
                            getAnimalCommand(dogs, name);
                            getAnimalCommand(hamsters, name);
                            getAnimalCommand(horses, name);
                            getAnimalCommand(donkeys, name);
                            getAnimalCommand(camels, name);
                            break;
                        case (3):
                            System.out.println();
                            Scanner scanner4 = new Scanner(System.in);
                            System.out.println("Введите имя животного");
                            name = scanner4.nextLine();
                            System.out.println("Введите новую комманду");
                            String command = scanner4.nextLine();
                            setAnimalCommand(dogs, name, command);
                            setAnimalCommand(cats, name, command);
                            setAnimalCommand(hamsters, name, command);
                            setAnimalCommand(horses, name, command);
                            setAnimalCommand(donkeys, name, command);
                            setAnimalCommand(camels, name, command);
                            break;
                    }
                }
            } else {
                System.out.println("Введите целое число");
                System.out.println();
            }
        }
    }
}
