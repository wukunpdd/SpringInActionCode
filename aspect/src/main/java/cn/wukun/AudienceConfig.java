package cn.wukun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @EnableAspectJAutoProxy注解：启用自动代理功能
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AudienceConfig {
    @Bean
    public Audience audience(){
        return new Audience();
    }

    @Bean
    public TrackCounter trackCounter(){
        return new TrackCounter();
    }
}
