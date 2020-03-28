package com.persen.bj.controler;

import cn.px.irs.hystrix.refresh.starter.RedisProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lijianyu on 2018/11/19.
 */
@Configuration
public class AutoConfiguration {
    //    @Bean
//    public RedisControler printAfterInitBean() {
//        return new RedisControler();
//    }
    @Bean
    public RedisProperties initRedisProperties(@Value("${spring.redis.host}") String host,
                                               @Value("${spring.redis.port}") int port,
                                               @Value("${spring.redis.database}") int database,
                                               @Value("${spring.redis.password}") String password,
                                               @Value("${spring.redis.timeout}") int timeout) {
        return new RedisProperties(host, port, database, password, timeout);
    }

}
