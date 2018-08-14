package cn.wukun;

import cn.wukun.config.RepositoryConfig;
import cn.wukun.dao.DbUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class DbUserTest {
    @Autowired
    private DbUserDao dbUserDao;

    @Test
    public void findById(){
        System.out.println("username:"+dbUserDao.findById(2).getUsername());
    }

    @Test
    public void findAll(){
        System.out.println("count:"+dbUserDao.findAll().size());
    }

    @Test
    public void getDbUserById(){
        System.out.println(dbUserDao.getDbUserById(1).getUsername());
    }
}
