package cn.wukun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * 类级别运用@Profile注解，它会告诉Spring这个配置中的bean只有在dev profile激活时才会创建
 */
@Configuration
@Profile(value = "dev")
public class EmbeddedDataSourceConfig {
    @Bean(destroyMethod = "shutdown")
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql") //数据库模式
                .addScript("classpath:test-data.sql") //测试数据
                .build();
    }
}
