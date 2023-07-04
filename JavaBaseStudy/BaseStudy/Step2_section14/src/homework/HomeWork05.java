package homework;

import java.util.HashSet;
import java.util.Objects;

public class HomeWork05 {
    public static void main(String[] args) {
        Person jay = new Person("jay", 001);
        Person jack = new Person("jack", 002);
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add(jay);
        hashSet.add(jack);
        jay.name = "jay1";
        hashSet.remove(jay);
        System.out.println(hashSet);
        hashSet.add(new Person("jay", 004));
        System.out.println(hashSet);
        hashSet.add(new Person("jay",003));
        System.out.println(hashSet);

    }
}

class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
