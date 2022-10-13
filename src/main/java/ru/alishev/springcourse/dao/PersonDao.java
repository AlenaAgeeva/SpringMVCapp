package ru.alishev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PersonDao {
    private List<Person> people;
    private static int ID;

    {
        people = new ArrayList<>(Arrays.asList(
                new Person(++ID, "Tom"),
                new Person(++ID, "Jhon"),
                new Person(++ID, "Sam"),
                new Person(++ID, "Kris")
        ));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public void save(Person person) {
        person.setId(++ID);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
