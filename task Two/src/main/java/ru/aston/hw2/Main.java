package ru.aston.hw2;

import ru.aston.hw2.dao.StudentDao;
import ru.aston.hw2.model.Book;
import ru.aston.hw2.model.Student;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        List<Student> students = dao.findAll();
        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBookList().stream())
                .sorted(Comparator.comparingInt(Book::getNoOfPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Книга не найдена")
                );
    }
}