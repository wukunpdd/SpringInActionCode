package cn.wukun.dao;

import cn.wukun.domain.Spitter;

import java.util.List;

public interface SpitterDao {
    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(int id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
