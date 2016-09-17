package com.persen.beijing.java.springmybatis.common;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.persen.beijing.java.springmybatis.dao.BilActAddUpMapper;
import com.persen.beijing.java.springmybatis.dao.BilActBalanceAddUpMapper;
import com.persen.beijing.java.springmybatis.po.BilActAddUp;
import com.persen.beijing.java.springmybatis.po.BilActBalanceAddUp;

@Scope("prototype")
@Component
public class dbOps {
    @Resource
    private BilActAddUpMapper baauMapper;
    @Resource
    private BilActBalanceAddUpMapper babauMapper;

    public void insert_bil(BilActAddUp value1) {
        baauMapper.insert(value1);
    }

    public void insert_balanceBil(BilActBalanceAddUp value2) {
        babauMapper.insert(value2);
    }
}
