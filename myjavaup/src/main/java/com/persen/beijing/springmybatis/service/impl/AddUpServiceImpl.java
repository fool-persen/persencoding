package com.persen.beijing.springmybatis.service.impl;

import java.sql.Date;

import javax.annotation.Resource;

import com.persen.beijing.springmybatis.biz.DBTool;
import com.persen.beijing.springmybatis.po.BilActAddUp;
import com.persen.beijing.springmybatis.po.BilActBalanceAddUp;

public class AddUpServiceImpl {
    @Resource
    private DBTool tool;

    public void process() {
        BilActAddUp baau = new BilActAddUp();
        baau.setUser_id("1");
        baau.setPartition_no("03");

        BilActBalanceAddUp value2 = new BilActBalanceAddUp();
        value2.setUser_id("1");
        value2.setBalance_id(1);
        value2.setBalance_type_id(1);
        value2.setUnit_type_id(1);
        value2.setAcct_month(1);
        value2.setPay_id("1");
        value2.setAcct_item_code(1);
        value2.setDeduct_fee(1);
        value2.setUpdate_time(new Date(0));
        value2.setPartition_no("03");

        tool.addUp(baau, value2);
    }
}
