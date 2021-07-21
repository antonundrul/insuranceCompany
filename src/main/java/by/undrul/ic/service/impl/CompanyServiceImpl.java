package by.undrul.ic.service.impl;

import by.undrul.ic.dao.CompanyDao;
import by.undrul.ic.entity.Company;
import by.undrul.ic.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao;

    @Autowired
    @Transactional
    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Transactional
    public List<Company> allCompanies() {
        return companyDao.allCompanies();
    }

    @Transactional
    public Company getById(int id) {
        return companyDao.getById(id);
    }
}
