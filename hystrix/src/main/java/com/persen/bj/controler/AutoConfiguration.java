package com.persen.bj.controler;

import cn.px.irs.hystrix.refresh.controler.RedisControler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lijianyu on 2018/11/19.
 */
//@Configuration
public class AutoConfiguration {
    @Bean
    public RedisControler printAfterInitBean() {
        return new RedisControler();
    }
}
