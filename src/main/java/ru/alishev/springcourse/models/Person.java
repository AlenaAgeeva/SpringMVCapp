package ru.alishev.springcourse.models;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Person {
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "Name should me no longer than 20 characters")
    private String name;
    @Min(value = 1, message = "Age should be greater than 1")
    private int age;
    @NotEmpty(message = "Should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    public Person() {
    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
