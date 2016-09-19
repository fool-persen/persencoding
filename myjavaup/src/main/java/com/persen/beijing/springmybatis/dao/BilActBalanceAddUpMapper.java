package com.persen.beijing.springmybatis.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.persen.beijing.springmybatis.po.BilActBalanceAddUp;

@Scope("prototype")
@Component
public interface BilActBalanceAddUpMapper {
    public int insert(BilActBalanceAddUp value);
}
