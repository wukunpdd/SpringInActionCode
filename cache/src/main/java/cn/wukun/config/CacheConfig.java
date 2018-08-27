package cn.wukun.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @CacheEvict 清除缓存
 * @Cacheable 配置缓存
 */
@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager(){
        System.out.println("CacheManager创建成功");
        return new ConcurrentMapCacheManager("userScoreCache");
    }
}
