package tarea3;

public class Person {

    String name;
    int age;
    String gen;

    public Person(String name, int age, String gen) {
        this.name = name;
        this.age = age;
        this.gen = gen;

    }

    void getPersonInfo() {
        String data = String.format("Name: %s || Age: %d || Gen: %s", name, age, gen);
        System.out.println(data);
    }
}
