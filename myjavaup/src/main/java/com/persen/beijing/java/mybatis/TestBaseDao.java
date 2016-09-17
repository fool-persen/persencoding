package com.persen.beijing.java.mybatis;

import java.io.IOException;
import java.io.Serializable;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;

import com.persen.beijing.java.mybatis.dao.IBaseGenericDAO;
import com.persen.beijing.java.mybatis.dao.InfoPayBalanceDao;
import com.persen.beijing.java.mybatis.dao.MybatisBaseGenericDAOImpl;
import com.persen.beijing.java.mybatis.po.InfoPayBalance;

public class TestBaseDao {

    private static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = "configuration.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources
                    .getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InfoPayBalance ipb = null;
        Long balanceId = 1111111115L;
        MybatisBaseGenericDAOImpl mbgdi = new InfoPayBalanceDao();
        mbgdi.setSqlSessionFactory(getSessionFactory());
        ipb = (InfoPayBalance) mbgdi.getById(balanceId);
        System.out.println(ipb);
    }
}
