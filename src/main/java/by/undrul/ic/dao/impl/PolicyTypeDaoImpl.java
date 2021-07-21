package by.undrul.ic.dao.impl;

import by.undrul.ic.dao.PolicyTypeDao;
import by.undrul.ic.entity.PolicyType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PolicyTypeDaoImpl implements PolicyTypeDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PolicyType> allPolicyTypes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from PolicyType").list();
    }

    @Override
    public PolicyType getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(PolicyType.class, id);
    }
}
