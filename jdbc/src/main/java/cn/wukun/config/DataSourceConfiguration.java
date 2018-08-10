package cn.wukun.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

/**
 * 配置数据源的四种方法展示
 */
@Configuration
@ComponentScan("cn.wukun.dao")
public class DataSourceConfiguration {

//    //开发环境数据源
//    @Profile("development")
//    @Bean
//    public DataSource developmentDataSource(){
//        /**
//         * 嵌入式数据原：每次重启应用或运行测试的时候，都能够重新填充测试数据
//         */
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("classpath:schema.sql")
//                .addScript("classpath:test-data.sql")
//                .build();
//    }
//
//    //QA数据源
//    @Profile("qa")
//    @Bean
//    public DataSource quDataSource(){
//        /**
//         * 数据源连接池
//         */
//        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setDriverClassName("org.h2.Driver");
//        basicDataSource.setUrl("jdbc:h2:tcp://localhost/~/spitter");
//        basicDataSource.setUsername("sa");
//        basicDataSource.setPassword("");
//        return basicDataSource;
//    }
//
//    //生产环境的数据源
//    @Profile("production")
//    @Bean
//    public DataSource productionDataSource(){
//        //使用JNDI数据源
//        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
//        jndiObjectFactoryBean.setJndiName("org.h2.Driver");
//        jndiObjectFactoryBean.setResourceRef(true);
//        jndiObjectFactoryBean.setProxyInterface(DataSource.class);
//        return (DataSource) jndiObjectFactoryBean.getObject();
//    }

    //基于JDBC驱动的数据源
    @Bean
    public DataSource jdbcDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
