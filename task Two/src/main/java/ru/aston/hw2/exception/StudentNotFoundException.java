package ru.aston.hw2.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Студент с id = " + id + " не найден!");
    }
}
