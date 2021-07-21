package by.undrul.ic.service.impl;

import by.undrul.ic.dao.CarDao;
import by.undrul.ic.entity.Car;
import by.undrul.ic.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CarServiceImpl implements CarService {
    private CarDao carDao;

    @Autowired
    @Transactional
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    public int add(Car car) {
        return carDao.add(car);
    }

    @Transactional
    public Car getById(int id) {
        return carDao.getById(id);
    }

    @Transactional
    public void delete(Car car) {
        carDao.delete(car);
    }
}
