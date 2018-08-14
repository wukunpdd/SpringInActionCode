package cn.wukun.dao.impl;

import cn.wukun.dao.SpitterDao;
import cn.wukun.domain.Spitter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional //事务注解
public class SpitterDaoImpl implements SpitterDao {

    /**
     * @PersistenceContext注解并不会真正注入EntityManager，它没有将真正的EntityManager设置给Repository
     * 而是给了它一个EntityManager代理。真正的EntityManager是与当前事务相关联的那一个，如果不存在这样的EntityManager，
     * 就会创建一个新的。这样就能始终以线程安全的方式使用实体管理器
     */
    @PersistenceContext
    private EntityManager entityManager;

    public long count() {
        return findAll().size();
    }

    public Spitter save(Spitter spitter) {
        entityManager.persist(spitter);
        return spitter;
    }

    public Spitter findOne(long id) {
        return entityManager.find(Spitter.class, id);
    }

    public Spitter findByUsername(String username) {
        return (Spitter) entityManager.createQuery("select s from Spitter s where s.username=?").setParameter(1, username).getSingleResult();
    }

    public List<Spitter> findAll() {
        return (List<Spitter>) entityManager.createQuery("select s from Spitter s").getResultList();
    }
}
