package ru.aston.hw1;

import ru.aston.hw1.model.Car;
import ru.aston.hw1.model.Driver;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Porsche", "911", "Red");
        Driver driver = new Driver("Andrey", "Petrov", car);
        Driver driver1 = new Driver("Sergey", "Ivanov", null);
        System.out.println(driver);
        car.setBrand("Lada");
        car.setModel("Priora");
        car.setColor("Blue");
        System.out.println(driver);
        System.out.println(car);
    }
}