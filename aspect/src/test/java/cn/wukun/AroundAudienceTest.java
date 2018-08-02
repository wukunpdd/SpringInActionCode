package cn.wukun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AroundAudienceConfig.class)
public class AroundAudienceTest {
    @Autowired
    private Performance performance;

    @Test
    public void test(){
        performance.perform();
    }

}
