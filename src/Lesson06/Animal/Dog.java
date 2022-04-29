package Lesson06.Animal;

public class Dog extends Animal{

    private final int MAX_RUN_DISTANCE = 500;
    public final int MAX_SWIM_DISTANCE = 10;
    private static int dogCount = 0;


    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        super.run(distance < MAX_RUN_DISTANCE ? distance : MAX_RUN_DISTANCE);
    }

    @Override
    public void swim(int distance) {
        super.swim(distance < MAX_SWIM_DISTANCE ? distance : MAX_SWIM_DISTANCE);
    }

    public static int getAmount() {
        return dogCount;
    }
}
