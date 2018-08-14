package cn.wukun;

import cn.wukun.config.JpaConfig;
import cn.wukun.dao.SpitterDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class SpitterTest {
    @Autowired
    private SpitterDao spitterDao;

    @Test
    public void count(){
        System.out.println("count:"+spitterDao.count());
    }
}
