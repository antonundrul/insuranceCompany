package by.undrul.ic.dao.impl;

import by.undrul.ic.dao.PolicyDao;
import by.undrul.ic.entity.Policy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PolicyDaoImpl implements PolicyDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Policy> allPolicies() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Policy").list();
    }

    @Override
    public void add(Policy policy) {
        Session session = sessionFactory.getCurrentSession();
        session.save(policy);
    }

    @Override
    public void delete(Policy policy) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(policy);
    }

    @Override
    public void edit(Policy policy) {
        Session session = sessionFactory.getCurrentSession();
        session.update(policy);
    }

    @Override
    public Policy getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Policy.class, id);
    }
}
