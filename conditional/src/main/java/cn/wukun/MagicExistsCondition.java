package cn.wukun;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistsCondition implements Condition {

  /**
   * 环境中是否包含magic属性作为判断条件，只有包含magic属性才会创建对应@Conditional注解下的bean
   * @param context
   * @param metadata
   * @return
   */
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    Environment env = context.getEnvironment();
    return env.containsProperty("magic");
  }
  
}
