package com.persen.beijing.java.springmybatis.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.persen.beijing.java.springmybatis.po.BilActBalanceAddUp;

@Scope("prototype")
@Component
public interface BilActBalanceAddUpMapper {
	public int insert(BilActBalanceAddUp value);
}
