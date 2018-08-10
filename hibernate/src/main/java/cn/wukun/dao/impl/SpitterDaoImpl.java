package cn.wukun.dao.impl;

import cn.wukun.dao.SpitterDao;
import cn.wukun.domain.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Repository
public class SpitterDaoImpl implements SpitterDao {

    private SessionFactory sessionFactory;

    @Inject
    public SpitterDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public Spitter save(Spitter spitter) {
        Serializable id = currentSession().save(spitter);
        return findOne((Integer)id);
    }

    @Override
    public Spitter findOne(int id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return (Spitter) currentSession()
                .createCriteria(Spitter.class)
                .add(Restrictions.eq("username", username))
                .list().get(0);
    }

    @Override
    public List<Spitter> findAll() {
        return (List<Spitter>) currentSession()
                .createCriteria(Spitter.class).list();
    }
}
