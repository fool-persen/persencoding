package com.persen.beijing.spring3.aop;

import org.springframework.aop.ThrowsAdvice;

import com.persen.beijing.spring3.LogAble;

public class TranscationManager extends LogAble implements ThrowsAdvice {
    public void afterThrowing(Exception ex) throws Throwable {
        LOGGER.info("------");
        LOGGER.info("运行afterThrowing");
        LOGGER.info("回滚成功");
    }
}
