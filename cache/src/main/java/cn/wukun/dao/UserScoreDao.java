package cn.wukun.dao;

import cn.wukun.dao.custom.UserScoreDaoCustom;
import cn.wukun.domain.UserScore;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserScoreDao extends JpaRepository<UserScore, Integer>,UserScoreDaoCustom {

    @Cacheable("userScoreCache")
    UserScore findOneByUserId(int userId);

    @Cacheable("userScoreCache")
    List<UserScore> findAll();

    @CacheEvict("userScoreCache")
    void delete(int userId);

    //void delete(int userId);
}
