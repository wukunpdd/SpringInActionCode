package cn.wukun;

import cn.wukun.config.HibernateConfig;
import cn.wukun.dao.SpitterDao;
import cn.wukun.domain.Spitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfig.class)
public class SpitterTest {
    @Autowired
    private SpitterDao spitterDao;

    @Test
    @Transactional
    public void count() {
        System.out.println("count:"+spitterDao.count());
    }

    @Test
    @Transactional
    public void findAll() {
        List<Spitter> spitterList = spitterDao.findAll();
        for(Spitter spitter:spitterList){
            System.out.println("spitter:"+spitter);
        }
    }

    @Test
    @Transactional
    public void save(){
        Spitter spitter = new Spitter();
        spitter.setEmail("wukunpdd@163.com");
        spitter.setFullName("wukun");
        spitter.setPassword("1234");
        spitter.setUpdateByEmail(0);
        spitter.setUsername("Kun");
        spitterDao.save(spitter);
        System.out.println("count:"+spitterDao.count());
    }

    @Test
    @Transactional
    public void findByUsername(){
        Spitter spitter = spitterDao.findByUsername("artnames");
        System.out.println("spitter:"+spitter);
    }
}
