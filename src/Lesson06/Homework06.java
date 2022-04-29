package Lesson06;

import Lesson06.Animal.Animal;
import Lesson06.Animal.Cat;
import Lesson06.Animal.Dog;

public class Homework06 {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Dog dogPushok = new Dog("Пушок");
        Cat catMurzik = new Cat("Мурзик");
        Cat catBorya = new Cat("Боря");

        dogBobik.run(400);
        dogPushok.swim(5);
        catMurzik.run(100);
        catBorya.swim(5);
        dogBobik.run(501);
        catMurzik.run(201);
        dogPushok.swim(11);

        System.out.println("Количество животных: " + Animal.getAmount());
        System.out.println("Количество кошек: " + Cat.getAmount());
        System.out.println("Количество собак: " + Dog.getAmount());
    }
}
