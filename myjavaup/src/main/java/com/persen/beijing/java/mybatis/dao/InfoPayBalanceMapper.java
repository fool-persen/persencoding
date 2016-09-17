package com.persen.beijing.java.mybatis.dao;

import com.persen.beijing.java.mybatis.po.InfoPayBalance;

public interface InfoPayBalanceMapper {
    public int countAll();

    public InfoPayBalance selectByBalanceId(long balance_id);

    public int insert(InfoPayBalance ipb);

    public int update(InfoPayBalance ipb);
}
