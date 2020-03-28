package com.persen.beijing.springmybatis;

import com.persen.beijing.springmybatis.dao.IBalanceTypeDefineDao;
import com.persen.beijing.springmybatis.po.BalanceTypeDefineData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lijy on 2017/5/13.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/springmybatis/mybatis-template.xml"})
public class TestMybatisTemplate {
	@Resource
	IBalanceTypeDefineDao balanceTypeDefineDao;

	@Test
	public void run() {
		//List<BalanceTypeDefineData> balanceTypeDefineDataList = sqlSessionTemplate.selectList("selectAll");
		List<BalanceTypeDefineData> balanceTypeDefineDataList1 = balanceTypeDefineDao.selectAll();
		System.out.println(balanceTypeDefineDataList1.size());
	}
}
