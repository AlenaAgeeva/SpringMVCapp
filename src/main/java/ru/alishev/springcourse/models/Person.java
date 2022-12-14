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
    @Size(min = 2, max = 20, message = "Name should be no longer than 20 characters")
    private String name;
    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 20, message = "Surname should be no longer than 20 characters")
    private String surname;
    @Min(value = 1, message = "Age should be greater than 1")
    private int age;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;
    private long tel;
    private long health_card_num;
    @Size(max = 50, message = "Doctor's name should be no longer than 50 characters")
    private String family_doctor;


    public Person() {
    }

    public Person(int id, String name, String surname,
                  int age, String email, long tel,
                  long health_card_num, String family_doctor) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.tel = tel;
        this.health_card_num = health_card_num;
        this.family_doctor = family_doctor;
    }
}
