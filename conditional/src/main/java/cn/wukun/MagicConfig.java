package cn.wukun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MagicConfig {

  @Bean
  @Conditional(MagicExistsCondition.class) //设置给@Conditional的类可以是任意实现了Condition接口的类型
  public MagicBean magicBean() {
    return new MagicBean();
  }
  
}