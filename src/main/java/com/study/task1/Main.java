package com.study.task1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\IdeaProjects\\Java_Lesson16_Serialization_XML_JSON\\src\\main\\java\\com\\study\\task1\\file1.txt");
        Animal animal1 = new Animal("Casper", "White", 3);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            oos.writeObject(animal1);
            animal1 = null;
            animal1 = (Animal) ois.readObject();
            System.out.println(animal1);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
