package cn.wukun.dao;

import cn.wukun.domain.DbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbUserDao extends JpaRepository<DbUser, Integer> {
    DbUser findOneById(int id);
}
