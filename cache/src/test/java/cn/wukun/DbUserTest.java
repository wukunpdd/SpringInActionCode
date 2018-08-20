package cn.wukun;

import cn.wukun.config.DataConfig;
import cn.wukun.config.ZeroConfig;
import cn.wukun.dao.DbUserDao;
import cn.wukun.domain.UserExt;
import cn.wukun.zero.UserExtDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 此测试的目的是证明同时只能有一个配置类的代码起作用
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ZeroConfig.class)
public class DbUserTest {

//    @Autowired
//    private DbUserDao dbUserDao;
//
//    @Test
//    public void test(){
//        System.out.println("DbUser:"+dbUserDao.findOneById(3));
//    }

    @Autowired
    private UserExtDao userExtDao;

    @Test
    public void save(){
        UserExt userExt = new UserExt();
        userExt.setExtName("刘德华");
        userExt.setExtAge(45);
        userExtDao.save(userExt);
    }
}
