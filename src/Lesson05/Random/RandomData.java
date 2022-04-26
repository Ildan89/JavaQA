package Lesson05.Random;

import java.util.Random;

public class RandomData {
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 80;
    private static final int MIN_SALARY = 50000;
    private static final int MAX_SALARY = 200000;
    private static final int MIN_MAIL_NAME = 5;
    private static final int MAX_MAIL_NAME = 10;

    private static String[] name = new String[] {"Александр", "Андрей", "Николай", "Вячеслав", "Никита", "Дминтрий"};
    private static String[] surname = new String[] {"Иванов", "Сидоров", "Николаев", "Антонов", "Сизов", "Назаров"};
    private static String[] patronymic = new String[] {"Александрович", "Андреевич", "Николаевич", "Никитич"};
    private static String[] position = new String[] {"QA", "ProductManager", "Analyst", "Designer", "programmer"};
    private static String[] mailPostfix= new String[] {"@mail.ru", "@gmail.com", "@yandex.ru"};

    private static Random random = new Random();

    private static <arrayType> arrayType randomFromArray(arrayType[] array) {
        return array[random.nextInt(array.length)];
    }

    private static int randomInt(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static String randomName() {
        return randomFromArray(name);
    }

    public static String randomSurname() {
        return randomFromArray(surname);
    }

    public static String randomPatronymic() {
        return randomFromArray(patronymic);
    }

    public static String randomFullName() {
        return randomSurname() + " " + randomName() + " " + randomPatronymic();
    }

    public static String randomPosition() {
        return randomFromArray(position);
    }

    public static int randomAge() {
        return randomInt(MIN_AGE, MAX_AGE);
    }

    public static int randomSalary() {
        return randomInt(MIN_SALARY, MAX_SALARY);
    }

    public static String randomPhone(){
        StringBuilder phone = new StringBuilder("+7");
        for (int i = 0; i < 10; i++) {
            phone.append(random.nextInt(10));
        }
        return phone.toString();
    }

    public static String randomMail() {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < randomInt(MIN_MAIL_NAME, MAX_MAIL_NAME); i++) {
            prefix.append((char) (0x61 + random.nextInt(0x7A - 0x61 + 1)));
        }
        return prefix + randomFromArray(mailPostfix);
    }
}
