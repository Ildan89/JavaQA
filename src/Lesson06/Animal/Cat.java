package Lesson06.Animal;

public class Cat extends Animal{

    private final int MAX_RUN_DISTANCE = 200;
    private static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        super.run(distance < MAX_RUN_DISTANCE ? distance : MAX_RUN_DISTANCE);
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать");;
    }

    public static int getAmount() {
        return catCount;
    }


}
