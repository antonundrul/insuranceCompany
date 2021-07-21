package by.undrul.ic.dao;

import by.undrul.ic.entity.PolicyType;

import java.util.List;

public interface PolicyTypeDao {
    List<PolicyType> allPolicyTypes();

    PolicyType getById(int id);
}
