package ru.aston.hw2.model;

import java.util.Objects;

public class Book {
    private static Long count = 0L;
    private Long id;
    private String name;
    private String author;
    private int year;
    private int noOfPages;

    public Book(String name, String author, int year, int noOfPages) {
        this.id = count;
        this.name = name;
        this.author = author;
        this.year = year;
        this.noOfPages = noOfPages;
        count++;
    }

    public Book(Long id, Book bookOriginal) {
        this.id = id;
        this.name = bookOriginal.name;
        this.author = bookOriginal.author;
        this.year = bookOriginal.year;
        this.noOfPages = bookOriginal.noOfPages;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return year == book.year && noOfPages == book.noOfPages && Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(author);
        result = 31 * result + year;
        result = 31 * result + noOfPages;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", noOfPages=" + noOfPages +
                '}';
    }
}
