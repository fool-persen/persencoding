package com.persen.beijing.springBoot.beanConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lijy on 2018/2/6.
 */

@Configuration
@ComponentScan("com.persen.beijing.springBoot.beanConfig")
public class JavaConfig {
	@Bean
	public FunctionService functionService() {
		return new FunctionService();
	}
}
