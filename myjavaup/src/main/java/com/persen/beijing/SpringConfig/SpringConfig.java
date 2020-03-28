package com.persen.beijing.SpringConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lijy on 2017/10/24.
 */
@Configuration
public class SpringConfig {

	@Bean
	public Piano piano() {
		return new Piano();
	}

	@Bean(name = "counter")
	public Counter counter() {
		return new Counter(12, "Shake it Off");
	}
}
