package by.undrul.ic.dao.impl;

import by.undrul.ic.dao.CurrencyDao;
import by.undrul.ic.entity.Currency;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyDaoImpl implements CurrencyDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Currency> allCurrencies() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Currency").list();
    }

    @Override
    public Currency getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Currency.class, id);
    }
}
