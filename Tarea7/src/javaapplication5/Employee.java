package javaapplication5;
import java.util.ArrayList;
public class Employee {

   private String name;
    private int age;
    private double salary;
    private ArrayList<BankAccount> accounts;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.accounts = new ArrayList<>();
    }

    public Employee(String name, int age, double salary, long accountNumber) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.accounts = new ArrayList<>();
        this.accounts.add(new BankAccount(accountNumber));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 65) {
            this.age = age;
        } else {
            System.out.println("Edad Invalida");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Salario Invalido");
        }
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public String getData() {
        return String.format("Nombre: %s, Edad: %d, Salario: %.2f", this.getName(), this.getAge(), this.getSalary());
    }
}
