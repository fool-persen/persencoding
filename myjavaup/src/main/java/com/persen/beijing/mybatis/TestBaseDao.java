package com.persen.beijing.mybatis;

import java.io.IOException;

import com.persen.beijing.mybatis.po.InfoPayBalance;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.persen.beijing.mybatis.dao.InfoPayBalanceDao;
import com.persen.beijing.mybatis.dao.MybatisBaseGenericDAOImpl;

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
