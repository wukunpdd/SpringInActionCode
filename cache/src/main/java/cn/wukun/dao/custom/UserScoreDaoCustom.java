package cn.wukun.dao.custom;

import cn.wukun.domain.UserScore;

public interface UserScoreDaoCustom {

    UserScore getUserScoreByUserId(int userId);

    UserScore getUserScoreByUserName(String userName, int userId);
}
