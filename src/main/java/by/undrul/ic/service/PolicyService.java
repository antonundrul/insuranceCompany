package by.undrul.ic.service;

import by.undrul.ic.entity.Policy;

import java.util.List;

public interface PolicyService {
    List<Policy> allPolicies();
    void add(Policy policy);

    void delete(Policy policy);
    void edit(Policy policy);

    Policy getById(int id);
}
