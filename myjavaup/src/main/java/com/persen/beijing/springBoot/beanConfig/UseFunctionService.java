package com.persen.beijing.springBoot.beanConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lijy on 2018/2/6.
 */

@Component
public class UseFunctionService {

	@Autowired
	FunctionService functionService;

	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}

	public String sayHello(String word) {
		return functionService.sayHello(word);
	}
}
