package by.undrul.ic.service;

import by.undrul.ic.entity.Car;

public interface CarService {
    int add(Car car);

    void delete(Car car);

    Car getById(int id);
}
