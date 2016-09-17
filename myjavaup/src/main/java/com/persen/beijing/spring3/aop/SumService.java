package com.persen.beijing.spring3.aop;

import java.sql.SQLException;

import com.persen.beijing.spring3.LogAble;

public class SumService extends LogAble {
    public void doSum() {
        LOGGER.info("doSum..");
        throw new RuntimeException("运行时错误");
    }


    public void doSumOther() throws SQLException {
        LOGGER.info("doSumOther..");
        throw new SQLException("SQL错误");
    }
}
