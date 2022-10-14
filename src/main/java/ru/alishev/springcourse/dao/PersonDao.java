package ru.alishev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int ID;
    private final static String URL = "jdbc:postgresql://localhost:5432/spring_mvc_app";
    private final static String USER = "postgres";
    private final static String PASS = "rbnftpsrbnftps2020";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public List<Person> index() {
        List<Person> list = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement()
                    .executeQuery("select * from person;");
            while (resultSet.next()) {
                list.add(new Person(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("email")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Person show(int id) {
//        return people.stream()
//                .filter(p -> p.getId() == id)
//                .findFirst()
//                .orElse(null);
        return null;
    }

    public void save(Person person) {
        try {
            connection.createStatement()
                    .executeUpdate("INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() +
                            "'," + person.getAge() + ",'" + person.getEmail() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        //people.removeIf(p -> p.getId() == id);
    }
}
