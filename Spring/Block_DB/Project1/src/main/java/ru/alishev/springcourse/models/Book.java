package ru.alishev.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id_book;

    @NotEmpty(message = "Название книг не должно быть пустым")
    @Size(min = 2, max = 150, message = "Название книги не должно быть менее 2 и более 150 симолов")
    private String name;

    @NotEmpty(message = "Автор не должен быть пустым")
    @Size(min = 2, max = 150, message = "Имя автора не должно быть от 2 до 150 симолов в длиной")
    private String author;

    @Min(value = 1500, message = "Год должен быть больше, чем 1500")
    private int data;

    public Book() {

    }

    public Book(int id_book, String name, String author, int data) {
        this.id_book = id_book;
        this.name = name;
        this.author = author;
        this.data = data;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
