package cn.wukun.dao;

import cn.wukun.domain.DbUser;

import java.util.List;

public interface DbUserDao {
    public void addDbUser(DbUser dbUser);

    public List<DbUser> findAll();

    public DbUser findById(int id);

    public DbUser save(DbUser dbUser);
}
