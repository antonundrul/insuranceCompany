package by.undrul.ic.service;

import by.undrul.ic.entity.PolicyType;

import java.util.List;

public interface PolicyTypeService {
    List<PolicyType> allPolicyTypes();

    PolicyType getById(int id);
}
