package Lesson05;


import Lesson05.Random.RandomData;

public class Homework05 {



    public static void main(String[] args) {
        Employee[] employee = new Employee[5];

        for (int i = 0; i < employee.length; i++) {
            employee[i] = new Employee(RandomData.randomFullName(), RandomData.randomPosition(), RandomData.randomMail()
                ,RandomData.randomPhone(), RandomData.randomAge(), RandomData.randomSalary());
            employee[i].printInfo();
        }

        System.out.println("\nСотрудники старше 40 лет:");
        for (int i = 0; i < employee.length; i++) {
            if(employee[i].getAge() > 40) {
                employee[i].printInfo();
            }
        }

    }



}
