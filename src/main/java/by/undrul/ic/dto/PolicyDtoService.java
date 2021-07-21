package by.undrul.ic.dto;

import by.undrul.ic.entity.Car;
import by.undrul.ic.entity.Person;
import by.undrul.ic.entity.Policy;

public interface PolicyDtoService {
    Person convertToPerson(PolicyDto policyDto);
    Car convertToCar(PolicyDto policyDto);
    Policy convertToPolicy(Person person, Car car, PolicyDto policyDto);
}
