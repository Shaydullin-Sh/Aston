package ru.aston.hw1.model;

import java.util.Objects;

public class Driver {
    private final String name;
    private final String lastName;
    private final Car car;

    public Driver(String name, String lastName, Car car) {
        if (name == null || lastName == null || car == null) {
            throw new NullPointerException("Заполните все поля водителя!");
        }
        this.name = name;
        this.lastName = lastName;
        this.car = new Car(car);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Car getCar() {
        return new Car(car);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;
        return Objects.equals(name, driver.name) && Objects.equals(lastName, driver.lastName) && car.equals(driver.car);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(lastName);
        result = 31 * result + car.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", car=" + car +
                '}';
    }
}
