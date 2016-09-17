package com.persen.beijing.java.springmybatis.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.persen.beijing.java.springmybatis.po.BilActAddUp;

@Scope("prototype")
@Component
public interface BilActAddUpMapper {
    public int insert(BilActAddUp value);

    public int update(BilActAddUp value);
}
