package cn.wukun.dao;

import cn.wukun.dao.custom.DbUserDaoCustom;
import cn.wukun.domain.DbUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DbUserDao extends JpaRepository<DbUser, Integer>,DbUserDaoCustom {

    DbUser findById(Integer id);

    List<DbUser> findAll();
}
