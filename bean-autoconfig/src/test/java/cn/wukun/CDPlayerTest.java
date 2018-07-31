package cn.wukun;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

    /**
     * 测试正确，证明自动扫描成功创建了bean
     */
    @Test
    public void cdShouldNotBeNull() {
      assertNotNull(cd);
    }

    /**
     * 证明MediaPlayer接口实现类CDPlayer自动装配CompactDisc成功
     */
    @Test
    public void play() {
      player.play();
    }

}
