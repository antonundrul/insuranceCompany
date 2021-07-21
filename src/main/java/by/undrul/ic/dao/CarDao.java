package by.undrul.ic.dao;

import by.undrul.ic.entity.Car;

public interface CarDao {
    int add(Car car);

    Car getById(int id);

    void delete(Car car);
}
