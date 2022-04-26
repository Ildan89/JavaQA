package Lesson05;

public class Employee {
    private String fullName;
    private String position;
    private String eMail;
    private String phoneNumber;
    private int age;
    private double salary;

    public Employee(String fullName, String position, String eMail, String phoneNumber, int age, double salary) {
        this.fullName = fullName;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", eMail='" + eMail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public void printInfo() {
        System.out.println(this);
    }

    public int getAge() {
        return age;
    }
}
