package com.persen.bj.dynamicconfig;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lijianyu on 2018/11/28.
 */
//@Configuration
public class InitDynamicConfig {

//    @Bean
//    public DynamicConfiguration dynamicConfiguration(DynamicConfigSource configource) {
//        DynamicConfiguration configuration = new DynamicConfiguration(configource,
//                new FixedDelayPollingScheduler(30 * 100, 60 * 100, false));
//
//        ConfigurationManager.install(configuration);// 安裝后会启动schedel,定时调用DynamicConfigSource.poll()更新配置
//        return configuration;
//    }

}