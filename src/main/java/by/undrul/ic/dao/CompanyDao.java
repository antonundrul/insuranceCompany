package by.undrul.ic.dao;

import by.undrul.ic.entity.Company;

import java.util.List;

public interface CompanyDao {
    List<Company> allCompanies();

    Company getById(int id);
}
