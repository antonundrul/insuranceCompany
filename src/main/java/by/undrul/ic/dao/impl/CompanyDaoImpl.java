package by.undrul.ic.dao.impl;

import by.undrul.ic.dao.CompanyDao;
import by.undrul.ic.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Company> allCompanies() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Company").list();
    }

    @Override
    public Company getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }
}
