package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import java.util.List;

@Component
public class PersonDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> index() {
        return jdbcTemplate.query("Select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * from Person where id = ?",
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(Person.class)).stream()
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person (name,surname,age,email,tel,health_card_num,family_doctor) VALUES(?,?,?,?,?,?,?)",
                person.getName(),
                person.getSurname(),
                person.getAge(),
                person.getEmail(),
                person.getTel(),
                person.getHealth_card_num(),
                person.getFamily_doctor());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?,surname=?,age=?,email=?,tel =?,health_card_num=?,family_doctor=? WHERE id=?",
                updatedPerson.getName(),
                updatedPerson.getSurname(),
                updatedPerson.getAge(),
                updatedPerson.getEmail(),
                updatedPerson.getTel(),
                updatedPerson.getHealth_card_num(),
                updatedPerson.getFamily_doctor(),
                id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
    }
}
