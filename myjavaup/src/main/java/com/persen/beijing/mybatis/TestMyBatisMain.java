package com.persen.beijing.mybatis;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.persen.beijing.mybatis.dao.InfoPayBalanceMapper;
import com.persen.beijing.mybatis.po.InfoPayBalance;

public class TestMyBatisMain {

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
        SqlSession session = getSessionFactory().openSession();
        InfoPayBalanceMapper infoPayBalanceMapper = session.getMapper(InfoPayBalanceMapper.class);
        int cnt = infoPayBalanceMapper.countAll();
        System.out.println(cnt);
        long bal = Long.parseLong("1000000048709");
        InfoPayBalance ipb = infoPayBalanceMapper.selectByBalanceId(bal);
        System.out.println(ipb);
        long balance_id = 123456789L;
        ipb.setBalance_id(balance_id);
        infoPayBalanceMapper.insert(ipb);
        ipb = infoPayBalanceMapper.selectByBalanceId(balance_id);
        System.out.println(ipb);
        ipb.setBalance(10);
        infoPayBalanceMapper.update(ipb);
        ipb = infoPayBalanceMapper.selectByBalanceId(balance_id);
        System.out.println(ipb);
        session.commit();
    }

}
