package ru.aston.hw2.model;

import java.util.List;
import java.util.Objects;

public class Student {
    private static Long count = 0L;
    private Long id;
    private int course;
    private String name;
    private String lastName;
    private String patronymic;
    private List<Book> bookList;

    public Student(int course, String name, String lastName, String patronymic, List<Book> bookList) {
        this.id = count;
        this.course = course;
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.bookList = bookList;
        count++;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;
        return course == student.course && Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(lastName, student.lastName) && Objects.equals(patronymic, student.patronymic) && Objects.equals(bookList, student.bookList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + course;
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(lastName);
        result = 31 * result + Objects.hashCode(patronymic);
        result = 31 * result + Objects.hashCode(bookList);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", course=" + course +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
