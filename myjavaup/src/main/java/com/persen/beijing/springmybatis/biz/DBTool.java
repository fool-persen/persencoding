package com.persen.beijing.springmybatis.biz;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.persen.beijing.springmybatis.common.dbOps;
import com.persen.beijing.springmybatis.po.BilActAddUp;
import com.persen.beijing.springmybatis.po.BilActBalanceAddUp;

@Scope("prototype")
@Component
public class DBTool {
    @Resource
    dbOps ops;

    public void addUp(BilActAddUp value1, BilActBalanceAddUp value2) {
        ops.insert_bil(value1);
        ops.insert_balanceBil(value2);
    }
}
