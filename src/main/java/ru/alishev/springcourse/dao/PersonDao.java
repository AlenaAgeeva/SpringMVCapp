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
                new Person(++ID, "Tom", 23, "tom@gmail.com"),
                new Person(++ID, "Jhon", 46, "someemail@gmail.com"),
                new Person(++ID, "Sam", 16, "newpostemail@yahoo.com"),
                new Person(++ID, "Kris", 65, "hellothere@gmail.com")
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
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
