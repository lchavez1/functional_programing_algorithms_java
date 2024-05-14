package org.example.entities;

import java.util.Comparator;

public class Employee{
    private String name;
    private String city;
    private Integer age;
    private String carrerLevel;

    public Employee(String name, String city, Integer age, String carrerLevel) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.carrerLevel = carrerLevel;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getAge() {
        return age;
    }

    public String getCarrerLevel() {
        return carrerLevel;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %d years - %s\n", name, city, age, carrerLevel);
    }
}
