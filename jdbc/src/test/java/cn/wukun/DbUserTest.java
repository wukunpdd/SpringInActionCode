package cn.wukun;

import cn.wukun.config.DataSourceConfiguration;
import cn.wukun.dao.DbUserDao;
import cn.wukun.domain.DbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= DataSourceConfiguration.class)
public class DbUserTest {

    @Autowired
    private DbUserDao dbUserDao;

    @Test
    public void testAddDbUser(){
        DbUser dbUser = new DbUser();
        dbUser.setUsername("李凯伦");
        dbUser.setMobile("18513212418");
        dbUser.setCardnumber("429006198906011234");
        dbUserDao.addDbUser(dbUser);
    }

    @Test
    public void testFindAll(){
        List<DbUser> dbUserList = dbUserDao.findAll();
        System.out.println("size:"+dbUserList.size());
    }

    @Test
    public void testFindById(){
        DbUser dbUser = dbUserDao.findById(2);
        System.out.println("DbUser:"+dbUser);
    }

    @Test
    public void testSave(){
        DbUser dbUser = new DbUser();
        dbUser.setUsername("夏静静");
        dbUser.setMobile("15555999371");
        dbUser.setCardnumber("341282198610020182");
        dbUserDao.save(dbUser);
    }
}
