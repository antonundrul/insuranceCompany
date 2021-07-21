package by.undrul.ic.service.impl;

import by.undrul.ic.dao.PolicyDao;
import by.undrul.ic.entity.Policy;
import by.undrul.ic.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {
    private PolicyDao policyDao;

    @Autowired
    @Transactional
    public void setPolicyDao(PolicyDao policyDao) {
        this.policyDao = policyDao;
    }

    @Transactional
    public List<Policy> allPolicies() {
        return policyDao.allPolicies();
    }

    @Transactional
    public void add(Policy policy) {
        policyDao.add(policy);
    }

    @Transactional
    public void delete(Policy policy) {
        policyDao.delete(policy);
    }

    @Transactional
    public void edit(Policy policy) {
        policyDao.edit(policy);
    }

    @Transactional
    public Policy getById(int id) {
        return policyDao.getById(id);
    }


}
