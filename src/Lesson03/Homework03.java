package Lesson03;

import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework03 {

    private static Random random = new Random();

    public static void main(String[] args) {
        int[] array = generateRandomArray(10, 0, 1);
        printIntArray("Сгенерированый бинарный массив\t", array);
        inverseBinaryArray(array);
        printIntArray("Массив после инверсии\t\t\t", array);
        printIntArray("Массив 100 элементов", generateSerialArray(100));
        array = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printIntArray("Массив до преобразования\t\t\t\t", array);
        doubleElementsLessThan(array, 6);
        printIntArray("Массив после удвоение чисел меньше 6-ти\t", array);
        int[][] array2D = new int[9][9];
        fillDiagonals(array2D);
        print2DArray("Двухмерный массив с заполненными диогоналями", array2D);
        array = createInitializedArray(10, 5);
        printIntArray("Инициализированная одним значением матрица", array);
        array = generateRandomArray(20, -100, 100);
        printIntArray("Случайный массив", array);
        printMinAndMaxValues(array);
    }

    public static int[] generateRandomArray(int length, int min, int max) throws IllegalArgumentException{
        if (min > max) {
            throw new IllegalArgumentException("min > max");
        }
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static void printIntArray(String message, int[] array) {
        System.out.println(message + ": " + Arrays.toString(array));
    }

    public static void print2DArray(String message, int[][] array) {
        System.out.println(message);
        for (int[] subArray : array) {
            System.out.println(Arrays.toString(subArray));
        }
    }

    public static void inverseBinaryArray(int[] array) {
        for (int i = 0; i < array.length ; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    public static int[] generateSerialArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static void doubleElementsLessThan(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= (array[i] < num) ? 2 : 1;
        }
    }

    public static void fillDiagonals(int array[][]) throws IllegalArgumentException {
        if (array.length != array[0].length) {
            throw new IllegalArgumentException("В качестве аргумента передана не квадратная матрица");
        }
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if((i == j) || (i + j == array.length-1)) {
                    array[i][j] = 1;
                }
            }
        }
    }

    public static int[] createInitializedArray(int length, int value) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = value;
        }
        return array;
    }

    public static void printMinAndMaxValues(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int element: array) {
            min = element < min ? element : min;
            max = element > max ? element : max;
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }

}
