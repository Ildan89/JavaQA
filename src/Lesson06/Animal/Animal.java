package Lesson06.Animal;

public class Animal {
    private static int animalCount = 0;
    private String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public static int getAmount() {
        return animalCount;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + "м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + "м.");
    }




}
