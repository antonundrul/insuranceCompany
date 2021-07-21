package by.undrul.ic.service.impl;

import by.undrul.ic.dao.PersonDao;
import by.undrul.ic.entity.Person;
import by.undrul.ic.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonDao personDao;

    @Autowired
    @Transactional
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional
    public int add(Person person) {
        return personDao.add(person);
    }

    @Transactional
    public void delete(Person person) {
        personDao.delete(person);
    }

    @Transactional
    public Person getById(int id) {
        return personDao.getById(id);
    }
}
