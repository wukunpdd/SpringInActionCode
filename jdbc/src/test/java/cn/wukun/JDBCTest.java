package cn.wukun;

import cn.wukun.config.DataSourceConfiguration;
import cn.wukun.dao.TestDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceConfiguration.class)
public class JDBCTest {
    @Autowired
    private TestDao testDao;

    @Test
    public void testInsert(){
        cn.wukun.domain.Test test = new cn.wukun.domain.Test();
        test.setUserNme("Tom");
        testDao.addTest(test);
    }

    @Test
    public void testUpdate(){
        cn.wukun.domain.Test test = new cn.wukun.domain.Test();
        test.setUserNme("Jack");
        test.setId(21);
        testDao.updateTest(test);
    }

    @Test
    public void testCheck(){
        int id = 21;
        cn.wukun.domain.Test test = testDao.checkTest(id);
        System.out.println("id:"+test.getId()+";userName:"+test.getUserNme());
    }
}
