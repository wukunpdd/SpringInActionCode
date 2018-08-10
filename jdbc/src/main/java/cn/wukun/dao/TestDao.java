package cn.wukun.dao;

import cn.wukun.domain.Test;

public interface TestDao {
    public void addTest(Test test);

    public void updateTest(Test test);

    public Test checkTest(int id);
}
