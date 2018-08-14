package cn.wukun.dao.impl;

import cn.wukun.dao.custom.DbUserDaoCustom;
import cn.wukun.domain.DbUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DbUserDaoImpl implements DbUserDaoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public DbUser getDbUserById(Integer id) {
        DbUser dbUser = (DbUser)entityManager.createQuery("select user from DbUser as user where id=?").setParameter(1, id).getSingleResult();
        return dbUser;
    }
}
