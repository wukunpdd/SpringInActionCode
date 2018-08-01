package cn.wukun;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class ScopedBeanTests {

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes=ComponentScannedConfig.class)
    public static class ComponentScannedScopedBeanTest {

      @Autowired
      private ApplicationContext context;

      @Test
      public void testProxyScope() { //原型作用域测试
        Notepad notepad1 = context.getBean(Notepad.class);
        Notepad notepad2 = context.getBean(Notepad.class);
        assertNotSame(notepad1, notepad2);
      }

      @Test
      public void testSingletonScope() { //单例作用域测试
        UniqueThing thing1 = context.getBean(UniqueThing.class);
        UniqueThing thing2 = context.getBean(UniqueThing.class);
        assertSame(thing1, thing2);
      }

    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes=ExplicitConfig.class)
    public static class ExplicitConfigScopedBeanTest {

        @Autowired
        private ApplicationContext context;

        @Test
        public void testProxyScope() { //原型作用域测试
          Notepad notepad1 = context.getBean(Notepad.class);
          Notepad notepad2 = context.getBean(Notepad.class);
          assertNotSame(notepad1, notepad2);
        }

        @Test
        public void testSingletonScope() { //单例作用域测试
          UniqueThing thing1 = context.getBean(UniqueThing.class);
          UniqueThing thing2 = context.getBean(UniqueThing.class);
          assertSame(thing1, thing2);
        }

    }
}
