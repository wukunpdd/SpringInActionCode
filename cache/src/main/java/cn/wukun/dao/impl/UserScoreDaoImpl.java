package cn.wukun.dao.impl;

import cn.wukun.dao.custom.UserScoreDaoCustom;
import cn.wukun.domain.UserScore;
import org.springframework.stereotype.Component;

import org.springframework.cache.annotation.Cacheable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 类级别的缓存
 * key = "#userId" 意味着查询中必需带有userId这个属性，否则无法缓存，调用接口也会报错
 * condition="#userId<100"
 */
@Component
@Cacheable(value = "userScoreCache", key = "#userId")
public class UserScoreDaoImpl implements UserScoreDaoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public UserScore getUserScoreByUserId(int userId) {
        String qryHql = "select userScore from UserScore userScore where userScore.userId = " + userId;
        UserScore userScore = (UserScore) entityManager.createQuery(qryHql).getSingleResult();
        return userScore;
    }

    public UserScore getUserScoreByUserName(String userName, int userId){
        String qryHql = "select userScore from UserScore userScore where userScore.userName = '" + userName + "' and userScore.userId = " + userId;
        UserScore userScore = (UserScore) entityManager.createQuery(qryHql).getSingleResult();
        return userScore;
    }
}
