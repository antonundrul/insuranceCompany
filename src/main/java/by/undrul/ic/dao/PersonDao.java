package by.undrul.ic.dao;

import by.undrul.ic.entity.Person;

public interface PersonDao {
    int add(Person person);

    Person getById(int id);

    void delete(Person person);
}
