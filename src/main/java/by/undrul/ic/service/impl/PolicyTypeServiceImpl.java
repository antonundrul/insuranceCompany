package by.undrul.ic.service.impl;

import by.undrul.ic.dao.PolicyTypeDao;
import by.undrul.ic.entity.PolicyType;
import by.undrul.ic.service.PolicyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PolicyTypeServiceImpl implements PolicyTypeService {
    private PolicyTypeDao policyTypeDao;

    @Autowired
    @Transactional
    public void setPolicyTypeDao(PolicyTypeDao policyTypeDao) {
        this.policyTypeDao = policyTypeDao;
    }

    @Transactional
    public List<PolicyType> allPolicyTypes() {
        return policyTypeDao.allPolicyTypes();
    }

    @Transactional
    public PolicyType getById(int id) {
        return policyTypeDao.getById(id);
    }
}
