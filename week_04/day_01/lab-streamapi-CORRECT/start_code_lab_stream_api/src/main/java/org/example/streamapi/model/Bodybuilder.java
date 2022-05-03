package org.example.streamapi.model;

import java.util.Objects;

public class Bodybuilder {
    private String name;
    private int lift;
    private int age;

    public String getName() {
        return name;
    }

    public int getLift() {
        return lift;
    }

    public int getAge() {
        return age;
    }

    public Bodybuilder(String name, int lift, int age) {
        this.name = name;
        this.lift = lift;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bodybuilder that = (Bodybuilder) o;
        return lift == that.lift && age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lift, age);
    }

    @Override
    public String toString() {
        return "Bodybuilder{" +
                "name='" + name + '\'' +
                ", lift=" + lift +
                ", age=" + age +
                '}';
    }
}
