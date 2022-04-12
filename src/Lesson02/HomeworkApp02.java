package Lesson02;

import java.util.Scanner;

public class HomeworkApp02 {

    public static void main(String[] args) {
        int num1 = getIntFromConsole("Введите число 1");
        int num2 = getIntFromConsole("Введите число 2");
        System.out.println("Входит ли сумма чисел в диапазон [10; 20]?: " + isSumFrom10to20(num1, num2));
        printNumSign(getIntFromConsole("Введите число"));
        consoleSpamming("Hello world!", 5);
        int year = getIntFromConsole("Введите год");
        System.out.println("Является ли год високосным?: " + isHighYear(year));
    }

    private static int getIntFromConsole(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message + ": ");
        return input.nextInt();
    }

    public static boolean isSumFrom10to20(int num1, int num2) {
        int sum = num1 + num2;
        return sum >= 10 && sum <= 20;
    }

    public static void printNumSign(int num) {
        if (isNumNegative(num)) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    public static boolean isNumNegative(int num) {
        return num < 0;
    }

    public static void consoleSpamming(String message, int numOfStr) {
        for (int i = 0; i < numOfStr; i++) {
            System.out.println(message);
        }
    }

    public static boolean isHighYear (int year) {
        //каждый 4-ый год високосный, при этом каждый 100-ый невисокосный, при этом каждый 400-ый високосный
        //проверить является ли год кратным некоторому числу можно проверив, равен ли остаток от деления нулю
        //каждый 400год всегда високосный поэтому после проверки на кратность 400 используем ИЛИ
        //каждый 4-ый високосный, при этом каждый 100-ый нет, так как должно выполняться сразу два условия используем И
        //В итоге получилась вот такая вот простая проверка (объединил в скобочки для наглядности) :
        return (year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0);
    }









}
