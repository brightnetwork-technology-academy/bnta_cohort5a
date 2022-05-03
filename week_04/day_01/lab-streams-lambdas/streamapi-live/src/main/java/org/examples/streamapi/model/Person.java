package org.examples.streamapi.model;

public class Person {
    public enum Gender {
        MALE, FEMALE, NON_BINARY, UNKNOWN
    }

    private String name;
    private String lastName;
    private int age;
    private Gender gender;

    public Person(String name, String lastName, int age, Gender gender) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
