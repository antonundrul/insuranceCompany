package by.undrul.ic.service;

import by.undrul.ic.entity.Person;

public interface PersonService {
    int add(Person person);

    Person getById(int id);

    void delete(Person person);

}
