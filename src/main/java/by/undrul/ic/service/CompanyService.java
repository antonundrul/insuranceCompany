package by.undrul.ic.service;

import by.undrul.ic.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> allCompanies();

    Company getById(int id);
}
