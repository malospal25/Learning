package ru.alishev.springcourse.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author Neil Alishev
 */
public class Person {
    private int id_people;

    @NotEmpty(message = "ФИО не должно быть пустым")
    @Size(min = 2, max = 250, message = "ФИО не должно содержать меньше 2 и больше 250 символов")
    private String fullName;

    @Min(value = 1900, message = "Год не должен быть меньше 1900")
    private int data;

    public Person() {

    }

    public Person(int id_people, String fullName, int data) {
        this.id_people = id_people;
        this.fullName = fullName;
        this.data = data;
    }

    public int getId_people() {
        return id_people;
    }

    public void setId_people(int id_people) {
        this.id_people = id_people;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
